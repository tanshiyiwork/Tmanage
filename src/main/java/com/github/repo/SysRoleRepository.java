package com.github.repo;

import com.github.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysRoleRepository extends JpaRepository<SysRole,Integer>, JpaSpecificationExecutor<SysRole> {
}
