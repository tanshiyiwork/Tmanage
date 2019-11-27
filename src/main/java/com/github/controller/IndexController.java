package com.github.controller;

import com.github.constant.TConstant;
import com.github.service.SysUserService;
import com.github.utils.CaptchaUtil;
import com.github.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return R.ok(sysUserService.login(username,password,captcha,request));
    }

    /**
     * 登录成功跳转页面
     * @return
     */
    @RequestMapping(value = "/loginSuccess")
    public String loginSuccess(){
        return "index";
    }

    /**
     * 登录失败跳转页面
     * @return
     */
    @RequestMapping(value = "/loginFail")
    public String loginFail(){
        return "login";
    }

}
