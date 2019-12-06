package com.github.service.impl;

import com.github.constant.TConstant;
import com.github.dto.UserDto;
import com.github.entity.SysUser;
import com.github.entity.SysUserRole;
import com.github.exception.BaseException;
import com.github.repo.SysMenuRepository;
import com.github.repo.SysUserRepository;
import com.github.repo.SysUserRoleRepository;
import com.github.security.Tuser;
import com.github.security.util.JwtUtil;
import com.github.service.SysUserService;
import com.github.utils.Tutil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service("sysUserService")
@Transactional
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;

    @Autowired
    private SysMenuRepository sysMenuRepository;

    @Autowired
    RedisTemplate redisTemplate;

    @Resource
    private AuthenticationManager authenticationManager;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertUser(UserDto userDto){
        boolean result = true;
        try {
            SysUser sysUser = new SysUser();
            BeanUtils.copyProperties(userDto,sysUser);
            // 默认密码 123456
            sysUser.setPassword(Tutil.encode("12345"));
            sysUserRepository.save(sysUser);
            List<SysUserRole> userRoles =userDto.getRoleList().stream().map(item ->{
                SysUserRole userRole = new SysUserRole();
                userRole.setRoleId(item);
                userRole.setUserId(sysUser.getUserId());
                return userRole;
            }).collect(Collectors.toList());
            sysUserRoleRepository.saveAll(userRoles);
        } catch (BeansException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateUser(UserDto userDto) {
        boolean result = true;
        try {
            SysUser sysUser = new SysUser();
            BeanUtils.copyProperties(userDto,sysUser);
            sysUserRepository.save(sysUser);
            sysUserRoleRepository.deleteSysUserRolesByUserIdEquals(sysUser.getUserId());
            List<SysUserRole> userRoles =userDto.getRoleList().stream().map(item ->{
                SysUserRole userRole = new SysUserRole();
                userRole.setRoleId(item);
                userRole.setUserId(sysUser.getUserId());
                return userRole;
            }).collect(Collectors.toList());
            sysUserRoleRepository.saveAll(userRoles);
        } catch (BeansException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteUser(Integer userId) {
        boolean result = true;
        try {
            sysUserRepository.deleteById(userId);
            sysUserRoleRepository.deleteSysUserRolesByUserIdEquals(userId);
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean restPass(Integer userId) {
        SysUser sysUser = sysUserRepository.save(new SysUser().setPassword(Tutil.encode("123456")).setUserId(userId));
        return sysUser == null;
    }

    @Override
    public SysUser findByUserName(String userName) {
        return sysUserRepository.findSysUserByUsername(userName);
    }

    @Override
    public boolean updateUserInfo(SysUser sysUser) {
        SysUser result = sysUserRepository.save(sysUser);
        return result == null;
    }

    @Override
    public String login(String userName, String passWord, String captcha, HttpServletRequest request) {
        // 验证验证码
        // 从redis中获取之前保存的验证码跟前台传来的验证码进行匹配
        /*Object kaptcha = redisTemplate.opsForValue().get(TConstant.T_IMAGE_SESSION_KEY);
        if (kaptcha == null) {
            throw new BaseException("验证码已失效");
        }
        if (!captcha.toLowerCase().equals(kaptcha)) {
            throw new BaseException("验证码错误");
        }*/
        //用户验证
        Authentication authentication = null;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername()去验证用户名和密码，
            // 如果正确，则存储该用户名密码到security 的 context中
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, passWord));
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                throw new BaseException("用户名或密码错误", 402);
            } else if (e instanceof DisabledException) {
                throw new BaseException("账户被禁用", 402);
            } else if (e instanceof AccountExpiredException) {
                throw new BaseException("账户过期无法验证", 402);
            } else {
                throw new BaseException("账户被锁定,无法登录", 402);
            }
        }
        //存储认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //生成token
        Tuser userDetail = (Tuser) authentication.getPrincipal();
        return JwtUtil.generateToken(userDetail);
    }

    @Override
    public Set<String> findPermsByUserId(Integer userId) {
        return sysMenuRepository.findPermsByUserId(userId).stream().filter(StringUtils::isNotEmpty).collect(Collectors.toSet());
    }

    @Override
    public Set<String> findRoleIdByUserId(Integer userId) {
        return sysUserRoleRepository.selectUserRoleListByUserId(userId)
                .stream()
                .map(item -> "ROLE_"+item)
                .collect(Collectors.toSet());
    }


}
