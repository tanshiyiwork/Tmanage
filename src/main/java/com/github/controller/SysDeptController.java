package com.github.controller;

import com.github.entity.SysDept;
import com.github.service.SysDeptService;
import com.github.utils.JsonDept;
import com.github.utils.R;
import io.swagger.annotations.Api;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="部门模块")
@Controller
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

    @RequestMapping("/getDetpTree")
    @ResponseBody
    public JSONArray getDetpTree(){
        List<JsonDept> jsonDepts = sysDeptService.getAllJsonDept(4);
        JSONArray jsonArray = JSONArray.fromObject(jsonDepts);
        return jsonArray;
    }
}
