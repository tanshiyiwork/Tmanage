package com.github.repo;

import com.github.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SysMenuRepository extends JpaRepository<SysMenu, Integer> , JpaSpecificationExecutor<SysMenu> {

    public SysMenu findByParentId(Integer parentId);

    @Query(nativeQuery = true,value = "SELECT m.perms" +
            "FROM sys_menu m, sys_user u, sys_user_role ur, sys_role_menu rm" +
            "WHERE (u.user_id = :userId" +
            "AND u.user_id = ur.user_id" +
            "AND ur.role_id = rm.role_id" +
            "AND rm.menu_id = m.menu_id)")
    public List<String> findPermsByUserId(@Param("userId")Integer userId);

    public List<SysMenu> findAllByMenuIdIn(List<Integer> menuIds);
}
