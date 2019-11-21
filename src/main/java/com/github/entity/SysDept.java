package com.github.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "SYS_DEPT")
public class SysDept {
    private String stId;
    private String deptId;
    private String deptName;
    private String parentId;
    private Integer sort;
    private Integer level;
    private String moudleId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String delFlag;

    @Id
    @Column(name = "ST_ID", nullable = false, length = 50)
    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    @Basic
    @Column(name = "DEPT_ID", nullable = true, length = 100)
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
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
    @Column(name = "PARENT_ID", nullable = true, length = 100)
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
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
        return Objects.equals(stId, sysDept.stId) &&
                Objects.equals(deptId, sysDept.deptId) &&
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
        return Objects.hash(stId, deptId, deptName, parentId, sort, level, moudleId, createTime, updateTime, delFlag);
    }
}
