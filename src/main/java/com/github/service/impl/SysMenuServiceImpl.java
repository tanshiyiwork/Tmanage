package com.github.service.impl;

import com.github.constant.MenuConstant;
import com.github.entity.SysMenu;
import com.github.exception.BaseException;
import com.github.repo.SysMenuRepository;
import com.github.repo.SysRoleMenuRepository;
import com.github.service.SysMenuService;
import com.github.utils.Tutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("sysMenuService")
@Transactional
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuRepository sysMenuRepository;

    @Autowired
    private SysRoleMenuRepository sysRoleMenuRepository;

    /**
     * 验证菜单参数是否正确
     */
    private void verifyForm(SysMenu menu) {
        //上级菜单类型
        int parentType = MenuConstant.MenuType.CATALOG.getValue();
        if (menu.getParentId() != 0) {
            SysMenu parentMenu = getMenuById(menu.getParentId());
            parentType = parentMenu.getType();
        }
        //目录、菜单
        if (menu.getType() == MenuConstant.MenuType.CATALOG.getValue() ||
                menu.getType() == MenuConstant.MenuType.MENU.getValue()) {
            if (parentType != MenuConstant.MenuType.CATALOG.getValue()) {
                throw new BaseException("上级菜单只能为目录类型");
            }
            return;
        }
        //按钮
        if (menu.getType() == MenuConstant.MenuType.BUTTON.getValue()) {
            if (parentType != MenuConstant.MenuType.MENU.getValue()) {
                throw new BaseException("上级菜单只能为菜单类型");
            }
        }
    }

    @Override
    public List<String> findPermsByUserId(Integer userId) {
        return sysMenuRepository.findPermsByUserId(userId);
    }

    @Override
    public SysMenu getMenuById(Integer parentId) {
        return sysMenuRepository.findByParentId(parentId);
    }

    @Override
    public List<SysMenu> selectMenuTree(Integer uid) {
        List<SysMenu> sysMenus = new ArrayList<>();
        List<SysMenu> menus = null;
        // 所有人有权限看到 只是没有权限操作而已 暂定这样
        if (uid != 0) {
            List<Integer> menuIdList = sysRoleMenuRepository.findMenuIdByUserId(uid);
            menus = sysMenuRepository.findAllByMenuIdIn(menuIdList);
        }else{
            menus =sysMenuRepository.findAll();
        }
        menus.forEach(menu -> {
            if (menu.getParentId() == null || menu.getParentId() == 0) {
                menu.setLevel(0);
                if (Tutil.exists(sysMenus, menu)) {
                    sysMenus.add(menu);
                }
            }
        });
        sysMenus.sort((o1, o2) -> o1.getSort().compareTo(o2.getSort()));
        Tutil.findChildren(sysMenus, menus, 0);
        return sysMenus;
    }
}
