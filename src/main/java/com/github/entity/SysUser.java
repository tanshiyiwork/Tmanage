package com.github.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "SYS_USER")
public class SysUser {
    private int userId;
    private String username;
    private String password;
    private Integer deptId;
    private Integer jobId;
    private String email;
    private String phone;
    private String avatar;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String lockFlag;
    private String delFlag;

    @Id
    @Column(name = "USER_ID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USERNAME", nullable = false, length = 64)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "JOB_ID", nullable = true)
    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 25)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PHONE", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "AVATAR", nullable = true, length = 255)
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
    @Column(name = "LOCK_FLAG", nullable = true, length = 1)
    public String getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(String lockFlag) {
        this.lockFlag = lockFlag;
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
        SysUser sysUser = (SysUser) o;
        return userId == sysUser.userId &&
                Objects.equals(username, sysUser.username) &&
                Objects.equals(password, sysUser.password) &&
                Objects.equals(deptId, sysUser.deptId) &&
                Objects.equals(jobId, sysUser.jobId) &&
                Objects.equals(email, sysUser.email) &&
                Objects.equals(phone, sysUser.phone) &&
                Objects.equals(avatar, sysUser.avatar) &&
                Objects.equals(createTime, sysUser.createTime) &&
                Objects.equals(updateTime, sysUser.updateTime) &&
                Objects.equals(lockFlag, sysUser.lockFlag) &&
                Objects.equals(delFlag, sysUser.delFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, deptId, jobId, email, phone, avatar, createTime, updateTime, lockFlag, delFlag);
    }
}
