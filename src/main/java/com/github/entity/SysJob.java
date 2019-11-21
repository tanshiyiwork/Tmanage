package com.github.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "SYS_JOB")
public class SysJob {
    private int inId;
    private String jobName;
    private Integer deptId;
    private Integer sort;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "IN_ID", nullable = false)
    public int getInId() {
        return inId;
    }

    public void setInId(int inId) {
        this.inId = inId;
    }

    @Basic
    @Column(name = "JOB_NAME", nullable = true, length = 255)
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Basic
    @Column(name = "DEPT_ID", nullable = true)
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysJob sysJob = (SysJob) o;
        return inId == sysJob.inId &&
                Objects.equals(jobName, sysJob.jobName) &&
                Objects.equals(deptId, sysJob.deptId) &&
                Objects.equals(sort, sysJob.sort) &&
                Objects.equals(createTime, sysJob.createTime) &&
                Objects.equals(updateTime, sysJob.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inId, jobName, deptId, sort, createTime, updateTime);
    }
}
