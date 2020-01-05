package com.github.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 系统角色表
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SYS_ROLE")
public class SysRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID", nullable = false)
    private Integer roleId;//角色主键

    @Basic
    @Column(name = "ROLE_NAME", nullable = true, length = 100)
    private String roleName;//角色名称

    @Basic
    @Column(name = "ROLE_CODE", nullable = true, length = 50)
    private String roleCode;//角色标识

    @Basic
    @Column(name = "ROLE_DESC", nullable = true, length = 255)
    private String roleDesc;//角色描述

    @Basic
    @Column(name = "DS_TYPE", nullable = true)
    private Integer dsType;//数据权限类型

    @Basic
    @Column(name = "DS_SCOPE", nullable = true, length = 255)
    private String dsScope;//数据权限范围

    @Basic
    @Column(name = "CREATE_TIME", nullable = false)
    private Timestamp createTime;//创建时间

    @Basic
    @Column(name = "UPDATE_TIME", nullable = false)
    private Timestamp updateTime;//更新时间

    @Basic
    @Column(name = "DEL_FLAG", nullable = false, length = 1)
    private String delFlag;//删除标识（0-正常,1-删除）
}
