package com.github.service.impl;

import com.github.entity.SysRole;
import com.github.repo.SysRoleRepository;
import com.github.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sysRoleService")
@Transactional
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Override
    public void saveOrUpdateSysRole(SysRole sysRole) {

    }
}
