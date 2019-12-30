package com.github.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ObjectUtil;
import com.github.entity.SysRole;
import com.github.service.SysRoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Api(value="角色模块")
@Controller
@RequestMapping("/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public Map<String, Object> saveOrUpdate(SysRole sysRole){
        Map<String, Object> jsonMap = new HashMap<>();
        if(ObjectUtil.isNull(sysRole.getRoleId())){//新增
            sysRole.setDelFlag("0");
            sysRole.setCreateTime(new Date());
            sysRoleService.saveOrUpdateSysRole(sysRole);
            jsonMap.put("code","200");
        }else{//修改
            SysRole oldRole = sysRoleService.findSysRoleByRoleId(sysRole.getRoleId(),"0");
            BeanUtil.copyProperties(sysRole,oldRole, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            oldRole.setUpdateTime(new Date());
            sysRoleService.saveOrUpdateSysRole(oldRole);
            jsonMap.put("code","300");
        }
        return jsonMap;
    }

    @RequestMapping("/getRoleInfoTable")
    @ResponseBody
    public Map<String, Object> getRoleInfoTable(int page,int pageSize){
        Map<String, Object> jsonMap = new HashMap<>();
        SysRole sysRole =  new SysRole();
        Page<SysRole> sysRolePage = sysRoleService.findSysRolePage(sysRole,page,pageSize);
        jsonMap.put("total", sysRolePage.getTotalElements());
        jsonMap.put("rows", sysRolePage.getContent());
        jsonMap.put("code",0);
        jsonMap.put("msg","success");
        return jsonMap;
    }

    @RequestMapping("/toEditRole")
    public ModelAndView toEditRole(String roleId){
        ModelAndView modelAndView = new ModelAndView();
        SysRole sysRole = sysRoleService.findSysRoleByRoleId(Integer.parseInt(roleId),"0");
        modelAndView.addObject("sysRole",sysRole);
        modelAndView.setViewName("roleAdd");
        return modelAndView;
    }

    @RequestMapping("/deleteRoleInfo")
    @ResponseBody
    public Map<String, Object> deleteRoleInfo(String roleId){
        Map<String, Object> jsonMap = new HashMap<>();
        try {
            sysRoleService.deleteSysRoleById(Integer.parseInt(roleId));
            jsonMap.put("code","200");
        }catch (Exception e){
            e.printStackTrace();
            jsonMap.put("code","500");
            return jsonMap;
        }
        return jsonMap;
    }

    @RequestMapping("/getRoleCommbo")
    @ResponseBody
    public List<Map<String,Object>> getRoleCommbo(){
        List<Map<String,Object>> list = new ArrayList<>();
        List<SysRole> sysRoles = sysRoleService.findAllSysRole();
        if(sysRoles!=null && sysRoles.size()>0){
            for (SysRole sysRole:sysRoles) {
                Map<String,Object> map = new HashMap<>();
                map.put("id",sysRole.getRoleId());
                map.put("text",sysRole.getRoleName());
                list.add(map);
            }
        }
        return list;
    }
}
