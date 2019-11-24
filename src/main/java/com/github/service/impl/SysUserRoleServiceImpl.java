package com.github.service.impl;

import com.github.entity.SysUserRole;
import com.github.repo.SysUserRoleRepository;
import com.github.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sysUserRoleService")
@Transactional
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;


    @Override
    public List<SysUserRole> findUserRoleListByUserId(Integer userId) {
        return sysUserRoleRepository.findAllByUserIdEquals(userId);
    }
}
