package com.github.repo;

import com.github.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SysRoleRepository extends JpaRepository<SysRole,Integer>, JpaSpecificationExecutor<SysRole> {
    SysRole findSysRoleByRoleIdIsAndAndDelFlagIs(Integer roleId,String delFlag);

    List<SysRole> findAllByDelFlagIs(String delFlag);
}
