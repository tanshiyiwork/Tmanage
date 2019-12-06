package com.github.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "SYS_DEPT")
public class SysDept {
    private Integer deptId;//部门主键ID
    private String deptCode;//部门编号
    private String deptName;//部门名称
    private Integer parentId;//上级部门
    private Integer sort;//排序
    private Integer level;//层级
    private String moudleId;//模块id
    private Timestamp createTime;
    private Timestamp updateTime;
    private String delFlag;//是否删除  -1：已删除  0：正常

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPT_ID", nullable = false, length = 12)
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "DEPT_CODE", nullable = true, length = 100)
    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    @Basic
    @Column(name = "DEPT_NAME", nullable = true, length = 150)
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "PARENT_ID", nullable = true, length = 12)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
    @Column(name = "LEVEL", nullable = true)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "MOUDLE_ID", nullable = true, length = 50)
    public String getMoudleId() {
        return moudleId;
    }

    public void setMoudleId(String moudleId) {
        this.moudleId = moudleId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysDept sysDept = (SysDept) o;
        return Objects.equals(deptId, sysDept.deptId) &&
                Objects.equals(deptCode, sysDept.deptCode) &&
                Objects.equals(deptName, sysDept.deptName) &&
                Objects.equals(parentId, sysDept.parentId) &&
                Objects.equals(sort, sysDept.sort) &&
                Objects.equals(level, sysDept.level) &&
                Objects.equals(moudleId, sysDept.moudleId) &&
                Objects.equals(createTime, sysDept.createTime) &&
                Objects.equals(updateTime, sysDept.updateTime) &&
                Objects.equals(delFlag, sysDept.delFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, deptCode, deptName, parentId, sort, level, moudleId, createTime, updateTime, delFlag);
    }
}
