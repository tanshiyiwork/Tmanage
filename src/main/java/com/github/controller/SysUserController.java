package com.github.controller;

import com.github.dto.UserDto;
import com.github.service.SysUserService;
import com.github.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户模块")
@RestController
@RequestMapping(value = "/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping
    @PreAuthorize("hasAuthority('sys:user:add')")
    public R insert(@RequestBody UserDto userDto){
        return R.ok(sysUserService.insertUser(userDto));
    }
}
