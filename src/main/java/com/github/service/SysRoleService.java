package com.github.service;

import com.github.entity.SysRole;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SysRoleService {
    void saveOrUpdateSysRole(SysRole sysRole);

    SysRole findSysRoleByRoleId(Integer roleId,String delFlag);

    Page<SysRole> findSysRolePage(SysRole sysRole, Integer page, Integer rows);

    void deleteSysRoleById(Integer roleId);

    List<SysRole> findAllSysRole();
}
