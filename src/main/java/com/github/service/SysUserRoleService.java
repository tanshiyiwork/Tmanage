package com.github.service;

import com.github.entity.SysRole;
import com.github.entity.SysUserRole;

import java.util.List;

public interface SysUserRoleService {

    public List<SysUserRole> findUserRoleListByUserId(Integer userId);

    List<SysRole> findRoleListByUserId(Integer userId) throws Exception;

    List<SysUserRole> findUserRoleListByRoleId(Integer roleId) throws Exception;

}
