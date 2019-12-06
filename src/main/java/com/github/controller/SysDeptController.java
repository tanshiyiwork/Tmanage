package com.github.controller;

import com.github.entity.SysDept;
import com.github.service.SysDeptService;
import com.github.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="部门模块")
@RestController
@RequestMapping("/dept")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 保存部门信息
     * @param sysDept
     * @return
     */
    @PostMapping
    public R save(@RequestBody SysDept sysDept) {
        return R.ok(sysDeptService.saveSysDept(sysDept));
    }
}
