package com.github.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.entity.SysDept;
import com.github.service.SysDeptService;
import com.github.utils.JsonDept;
import com.github.utils.R;
import com.github.utils.ZtreeNode;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<JsonDept> getDetpTree(){
        List<JsonDept> jsonDepts = sysDeptService.getAllJsonDept();
        return jsonDepts;
    }

    @RequestMapping("/getDetpZtree")
    @ResponseBody
    public List<ZtreeNode> getDetpZtree(){
        List<ZtreeNode> ztreeNodes = sysDeptService.getDpetZtreeNodesById(4);
        return ztreeNodes;
    }

    @RequestMapping("/getDeptInfoTable")
    @ResponseBody
    public Map<String, Object> getDeptInfoTable(int page,int rows,String tid){
        Map<String, Object> jsonMap = new HashMap<>();
        SysDept sysDept =  new SysDept();
        sysDept.setParentId(Integer.parseInt(tid));
        Page<SysDept> sysDeptPage = sysDeptService.findSysDeptPage(sysDept,page,rows);
        jsonMap = convertJpaPageToJson(sysDeptPage);
        return jsonMap;
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public Map<String, Object> saveOrUpdate(SysDept sysDept){
        Map<String, Object> jsonMap = new HashMap<>();
        if(ObjectUtil.isNull(sysDept.getDeptId())){//新增
            sysDept.setDelFlag("0");
            sysDept.setCreateTime(new Date());
            sysDeptService.saveSysDept(sysDept);
            jsonMap.put("code","200");
        }else{//修改

        }
        return jsonMap;
    }

    public static Map<String, Object> convertJpaPageToJson(Page<?> page) {
        Map<String, Object> jsonMap = new HashMap();
        jsonMap.put("total", page.getTotalElements());
        jsonMap.put("rows", page.getContent());
        return jsonMap;
    }
}
