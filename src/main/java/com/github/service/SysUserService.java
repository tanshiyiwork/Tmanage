package com.github.service;

import com.github.entity.SysUser;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public interface SysUserService {
    /**
     * 保存用户以及角色部门等信息
     * @param sysUser
     * @return
     */
    public boolean insertUser(SysUser sysUser);

    /**
     * 更新用户以及角色部门等信息
     * @param sysUser
     * @return
     */
    public boolean updateUser(SysUser sysUser);

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    public boolean deleteUser(Integer userId);

    /**
     * 重置密码
     * @param userId
     * @return
     */
    public boolean restPass(Integer userId);

    /**
     * 通过用户名查找用户
     * @param userName
     * @return
     */
    public SysUser findByUserName(String userName);

    /**
     * 修改用户信息
     * @param sysUser
     * @return
     */
    public boolean updateUserInfo(SysUser sysUser);

    /**
     * 登录
     * @param userName
     * @param passWord
     * @param captcha
     * @param request
     * @return
     */
    public String login(String userName, String passWord, String captcha, HttpServletRequest request);

    /**
     * 根据用户id查询权限
     * @param userId
     * @return
     */
    Set<String> findPermsByUserId(Integer userId);

    /**
     * 通过用户id查询角色ID集合
     * @param userId
     * @return
     */
    Set<String> findRoleIdByUserId(Integer userId);

    /**
     * 通过用户id查询角色标识集合
     * @param userId
     * @return
     */
    Set<String> findRoleCodeByUserId(Integer userId);

    Page<SysUser> findSysUserPage(SysUser sysUser,Integer page,Integer pageSize);

    SysUser findSysUserByUserId(Integer userId);

}
