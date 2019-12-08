package com.github.service;

import com.github.entity.SysMenu;

import java.util.List;

public interface SysMenuService {

    /**
     * 根据用户id查询权限
     * @param userId
     * @return
     */
    List<String> findPermsByUserId(Integer userId);

    /**
     * 根据父id查询菜单
     * @param parentId
     * @return
     */
    SysMenu getMenuById(Integer parentId);

    /**
     * 根据用户id查找菜单树
     * @param uid
     * @return
     */
    List<SysMenu> selectMenuTree(Integer uid);

    /**
     * 添加菜单
     * @param sysMenu
     * @return
     */
    SysMenu saveMenu(SysMenu sysMenu);
}
