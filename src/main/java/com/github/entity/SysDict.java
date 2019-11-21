package com.github.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "SYS_DICT")
public class SysDict {
    private String stId;
    private String name;
    private String code;
    private String value;
    private String description;
    private String parentId;
    private Integer sort;
    private Integer level;
    private Timestamp cteateTime;
    private Timestamp updateTime;
    private String remark;
    private Integer delFlag;

    @Id
    @Column(name = "ST_ID", nullable = false, length = 50)
    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "CODE", nullable = false, length = 100)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "VALUE", nullable = false, length = 100)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "PARENT_ID", nullable = true, length = 50)
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
    @Column(name = "CTEATE_TIME", nullable = true)
    public Timestamp getCteateTime() {
        return cteateTime;
    }

    public void setCteateTime(Timestamp cteateTime) {
        this.cteateTime = cteateTime;
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
    @Column(name = "REMARK", nullable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "DEL_FLAG", nullable = true)
    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysDict sysDict = (SysDict) o;
        return Objects.equals(stId, sysDict.stId) &&
                Objects.equals(name, sysDict.name) &&
                Objects.equals(code, sysDict.code) &&
                Objects.equals(value, sysDict.value) &&
                Objects.equals(description, sysDict.description) &&
                Objects.equals(parentId, sysDict.parentId) &&
                Objects.equals(sort, sysDict.sort) &&
                Objects.equals(level, sysDict.level) &&
                Objects.equals(cteateTime, sysDict.cteateTime) &&
                Objects.equals(updateTime, sysDict.updateTime) &&
                Objects.equals(remark, sysDict.remark) &&
                Objects.equals(delFlag, sysDict.delFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stId, name, code, value, description, parentId, sort, level, cteateTime, updateTime, remark, delFlag);
    }
}
