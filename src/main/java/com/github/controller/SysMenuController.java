package com.github.controller;

import com.github.entity.SysMenu;
import com.github.service.SysMenuService;
import com.github.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "菜单模块")
@RestController
@RequestMapping(value = "/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 添加菜单
     * @param sysMenu
     * @return
     */
    @PreAuthorize("hasAuthority('sys:menu:add')")
    @PostMapping
    public R save(@RequestBody SysMenu sysMenu){
        return R.ok(sysMenuService.saveMenu(sysMenu));
    }
}
