package com.github.repo;

import com.github.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser,Integer>, JpaSpecificationExecutor<SysUser> {

    public SysUser findSysUserByUsername(String userName);

    SysUser findSysUserByUserIdIs(Integer userId);
}
