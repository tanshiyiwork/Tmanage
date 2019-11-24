package com.github.repo;

import com.github.entity.SysRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SysRoleMenuRepository extends JpaRepository<SysRoleMenu,Integer> {

    @Query(value = "SELECT rm.menu_id" +
            "FROM sys_role_menu rm, sys_user_role ur, sys_user u" +
            "WHERE (u.user_id = :userId" +
            "AND u.user_id = ur.user_id" +
            "AND rm.role_id = ur.role_id)",nativeQuery = true)
    public List<Integer> findMenuIdByUserId(@Param("userId")Integer userId);
}
