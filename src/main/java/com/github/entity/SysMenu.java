package com.github.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "SYS_MENU")
public class SysMenu {
    private int menuId;
    private String name;
    private String perms;
    private String path;
    private String component;
    private Integer parentId;
    private String icon;
    private Integer sort;
    private String type;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String delFlag;
    private Byte isFrame;

    @Id
    @Column(name = "MENU_ID", nullable = false)
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PERMS", nullable = true, length = 32)
    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    @Basic
    @Column(name = "PATH", nullable = true, length = 128)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "COMPONENT", nullable = true, length = 255)
    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    @Basic
    @Column(name = "PARENT_ID", nullable = true)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "ICON", nullable = true, length = 32)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "SORT", nullable = true)
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "TYPE", nullable = true, length = 1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "CREATE_TIME", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "UPDATE_TIME", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "DEL_FLAG", nullable = true, length = 1)
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Basic
    @Column(name = "IS_FRAME", nullable = true)
    public Byte getIsFrame() {
        return isFrame;
    }

    public void setIsFrame(Byte isFrame) {
        this.isFrame = isFrame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysMenu sysMenu = (SysMenu) o;
        return menuId == sysMenu.menuId &&
                Objects.equals(name, sysMenu.name) &&
                Objects.equals(perms, sysMenu.perms) &&
                Objects.equals(path, sysMenu.path) &&
                Objects.equals(component, sysMenu.component) &&
                Objects.equals(parentId, sysMenu.parentId) &&
                Objects.equals(icon, sysMenu.icon) &&
                Objects.equals(sort, sysMenu.sort) &&
                Objects.equals(type, sysMenu.type) &&
                Objects.equals(createTime, sysMenu.createTime) &&
                Objects.equals(updateTime, sysMenu.updateTime) &&
                Objects.equals(delFlag, sysMenu.delFlag) &&
                Objects.equals(isFrame, sysMenu.isFrame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, name, perms, path, component, parentId, icon, sort, type, createTime, updateTime, delFlag, isFrame);
    }
}
