package com.github.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SYS_ROLE_DEPT")
public class SysRoleDept {
    private int inId;
    private Integer roleId;
    private Integer deptId;

    @Id
    @Column(name = "IN_ID", nullable = false)
    public int getInId() {
        return inId;
    }

    public void setInId(int inId) {
        this.inId = inId;
    }

    @Basic
    @Column(name = "ROLE_ID", nullable = true)
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "DEPT_ID", nullable = true)
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRoleDept that = (SysRoleDept) o;
        return inId == that.inId &&
                Objects.equals(roleId, that.roleId) &&
                Objects.equals(deptId, that.deptId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inId, roleId, deptId);
    }
}
