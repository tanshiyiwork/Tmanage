package com.github.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONArray;
import com.github.entity.SysRole;
import com.github.entity.SysUser;
import com.github.service.SysUserRoleService;
import com.github.service.SysUserService;
import com.github.utils.Tutil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Api(value = "用户模块")
@Controller
@RequestMapping(value = "/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public Map<String, Object> saveOrUpdate(SysUser sysUser){
        Map<String, Object> jsonMap = new HashMap<>();
        if(ObjectUtil.isNull(sysUser.getUserId())){//新增
            sysUser.setDelFlag("0");
            sysUser.setCreateTime(new Date());
            boolean code =sysUserService.insertUser(sysUser);
            if(code){
                jsonMap.put("code","200");
            }else{
                jsonMap.put("code","500");
            }
        }else{//修改
            SysUser oldUser = sysUserService.findSysUserByUserId(sysUser.getUserId());
            BeanUtil.copyProperties(sysUser,oldUser, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            oldUser.setUpdateTime(new Date());
            boolean code = sysUserService.updateUser(oldUser);
            if(code){
                jsonMap.put("code","300");
            }else{
                jsonMap.put("code","500");
            }
        }
        return jsonMap;
    }

    @RequestMapping("/getUserInfoTable")
    @ResponseBody
    public Map<String, Object> getUserInfoTable(int page,int pageSize,SysUser sysUser){
        Map<String, Object> jsonMap = new HashMap<>();
        Page<SysUser> sysUserPage = sysUserService.findSysUserPage(sysUser,page,pageSize);
        jsonMap.put("total", sysUserPage.getTotalElements());
        jsonMap.put("rows", sysUserPage.getContent());
        jsonMap.put("code",0);
        jsonMap.put("msg","success");
        return jsonMap;
    }

    @RequestMapping("/toEditUser")
    public ModelAndView toEditUser(String userId){
        ModelAndView modelAndView = new ModelAndView();
        SysUser sysUser = sysUserService.findSysUserByUserId(Integer.parseInt(userId));
        JSONArray roleIds = new JSONArray();
        if(sysUser!= null && sysUser.getUserId()!=null){
            List<SysRole> sysRoleList = new ArrayList<>();
            try {
                sysRoleList = sysUserRoleService.findRoleListByUserId(sysUser.getUserId());
                sysUser.setRoleList(sysRoleList);
                for (SysRole role:sysRoleList) {
                    roleIds.add(role.getRoleId());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        modelAndView.addObject("sysUser",sysUser);
        modelAndView.addObject("roleIds",roleIds);
        modelAndView.setViewName("userAdd");
        return modelAndView;
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public Map<String, Object> deleteUser(String userId){
        Map<String, Object> jsonMap = new HashMap<>();
        boolean result = sysUserService.deleteUser(Integer.parseInt(userId));
        if(result){
            jsonMap.put("code","200");
        }else{
            jsonMap.put("code","500");
        }
        return jsonMap;
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public Map<String, Object> updatePassword(String newPassword,SysUser sysUser){
        Map<String, Object> jsonMap = new HashMap<>();
        try {
            SysUser oldSysuser = sysUserService.findSysUserByUserId(sysUser.getUserId());
            if(Tutil.matches(sysUser.getPassword(),oldSysuser.getPassword())){
                sysUserService.updateUserPassword(newPassword,sysUser.getUserId());
                jsonMap.put("code","200");
            }else{//原密码有误
                jsonMap.put("code","300");
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonMap.put("code","500");
        }
        return jsonMap;
    }
}
