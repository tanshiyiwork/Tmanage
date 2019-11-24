package com.github.repo;

import com.github.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SysUserRoleRepository extends JpaRepository<SysUserRole,Integer> {

    public void deleteSysUserRolesByUserIdEquals(Integer userId);

    public List<SysUserRole> findAllByUserId(Integer userId);

    @Query(value = "SELECT r.role_name, ur.role_id" +
            "FROM sys_role r" +
            "LEFT JOIN sys_user_role ur ON r.role_id = ur.role_id" +
            "LEFT JOIN sys_user u ON u.user_id = ur.user_id" +
            "WHERE u.user_id = #{userId}",nativeQuery = true)
    List<SysUserRole> selectUserRoleListByUserId(Integer userId);
}
