package com.github.controller;

import com.github.service.SysUserService;
import com.github.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(value = "主页模块")
@RestController
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

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
}
