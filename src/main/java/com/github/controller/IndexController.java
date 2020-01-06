package com.github.controller;

import com.github.constant.TConstant;
import com.github.entity.SysUser;
import com.github.security.Tuser;
import com.github.service.SysUserService;
import com.github.utils.CaptchaUtil;
import com.github.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Api(value = "主页模块")
@Controller
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * 生成验证码
     * @param response
     * @param request
     * @throws IOException
     */
    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成图片验证码
        BufferedImage image = CaptchaUtil.createImage();
        // 生成文字验证码
        String randomText = CaptchaUtil.drawRandomText(image);
        // 保存到验证码到 redis 有效期两分钟
        redisTemplate.opsForValue().set(TConstant.T_IMAGE_SESSION_KEY, randomText.toLowerCase(),2, TimeUnit.MINUTES);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpeg", out);
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param captcha
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request){
        String data = sysUserService.login(username,password,captcha,request);
        return R.ok(data);
    }

    @RequestMapping("/toPersonalInfo")
    public ModelAndView toPersonalInfo(String userId){
        ModelAndView modelAndView = new ModelAndView();
        Tuser curUser = getCurLoginUser();
        if(curUser!=null){
            SysUser sysUser = sysUserService.findSysUserByUserId(curUser.getUserId());
            modelAndView.addObject("sysUser",sysUser);
        }
        modelAndView.setViewName("personal");
        return modelAndView;
    }

    /**
     * 获取当前登录人信息
     * @return
     */
    private Tuser getCurLoginUser(){
        Tuser tuser = null;
        /**
         SecurityContextHolder.getContext()获取安全上下文对象，就是那个保存在 ThreadLocal 里面的安全上下文对象
         总是不为null(如果不存在，则创建一个authentication属性为null的empty安全上下文对象)
         获取当前认证了的 principal(当事人),或者 request token (令牌)
         如果没有认证，会是 null,该例子是认证之后的情况
         */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //有登陆用户就返回登录用户，没有就返回null
        if (authentication != null) {
            if (authentication instanceof AnonymousAuthenticationToken) {
                return null;
            }
            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                tuser =(Tuser)authentication.getPrincipal();
            }
        }
        return tuser;
    }
}
