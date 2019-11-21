package com.github.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "SYS_ROLE")
public class SysRole {
    private int roleId;
    private String roleName;
    private String roleCode;
    private String roleDesc;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String delFlag;
    private Integer dsType;
    private String dsScope;

    @Id
    @Column(name = "ROLE_ID", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "ROLE_NAME", nullable = true, length = 100)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "ROLE_CODE", nullable = true, length = 50)
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Basic
    @Column(name = "ROLE_DESC", nullable = true, length = 255)
    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Basic
    @Column(name = "CREATE_TIME", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "UPDATE_TIME", nullable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "DEL_FLAG", nullable = false, length = 1)
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Basic
    @Column(name = "DS_TYPE", nullable = true)
    public Integer getDsType() {
        return dsType;
    }

    public void setDsType(Integer dsType) {
        this.dsType = dsType;
    }

    @Basic
    @Column(name = "DS_SCOPE", nullable = true, length = 255)
    public String getDsScope() {
        return dsScope;
    }

    public void setDsScope(String dsScope) {
        this.dsScope = dsScope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRole sysRole = (SysRole) o;
        return roleId == sysRole.roleId &&
                Objects.equals(roleName, sysRole.roleName) &&
                Objects.equals(roleCode, sysRole.roleCode) &&
                Objects.equals(roleDesc, sysRole.roleDesc) &&
                Objects.equals(createTime, sysRole.createTime) &&
                Objects.equals(updateTime, sysRole.updateTime) &&
                Objects.equals(delFlag, sysRole.delFlag) &&
                Objects.equals(dsType, sysRole.dsType) &&
                Objects.equals(dsScope, sysRole.dsScope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, roleCode, roleDesc, createTime, updateTime, delFlag, dsType, dsScope);
    }
}
