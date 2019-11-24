package com.github.service;

import com.github.entity.SysUserRole;

import java.util.List;

public interface SysUserRoleService {

    public List<SysUserRole> findUserRoleListByUserId(Integer userId);
}
