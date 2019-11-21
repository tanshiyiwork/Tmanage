package com.github.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SYS_ROLE_MENU")
public class SysRoleMenu {
    private int stId;
    private int roleId;
    private int menuId;

    @Id
    @Column(name = "ST_ID", nullable = false)
    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    @Basic
    @Column(name = "ROLE_ID", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "MENU_ID", nullable = false)
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRoleMenu that = (SysRoleMenu) o;
        return stId == that.stId &&
                roleId == that.roleId &&
                menuId == that.menuId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stId, roleId, menuId);
    }
}
