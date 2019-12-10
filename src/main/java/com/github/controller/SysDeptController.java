package com.github.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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

    @RequestMapping("/getDetpTree")
    public JSONArray getDetpTree(){
        JSONArray jsonArray = new JSONArray();
        JSONArray children = new JSONArray();
        JSONObject son = new JSONObject();
        son.put("id","2");
        son.put("name","1");
        son.put("open",true);
        son.put("checked",true);
        JSONObject son1 = new JSONObject();
        son1.put("id","3");
        son1.put("name","2");
        son1.put("open",false);
        son1.put("checked",true);
        children.add(son);
        children.add(son1);
        JSONObject object = new JSONObject();
        object.put("id","1");
        object.put("name","zzz");
        object.put("open",true);
        object.put("checked",true);
        object.put("children",children);
        jsonArray.add(object);
        return jsonArray;
    }
}
