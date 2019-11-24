package com.github.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@EqualsAndHashCode
@Accessors(chain = true)
@Entity
@Table(name = "SYS_USER")
public class SysUser {
    /**
     * TABLE使用一个特定的数据库表格来保存主键。
     * SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
     * IDENTITY：主键由数据库自动生成（主要是自动增长型）
     * AUTO：主键由程序控制。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Integer userId;//主键ID

    @Column(name = "USERNAME", nullable = false, length = 64)
    private String username;//用户名

    @Column(name = "PASSWORD", nullable = false, length = 255)
    private String password;//密码

    @Column(name = "DEPT_ID", nullable = true)
    private Integer deptId;//部门ID

    @Column(name = "JOB_ID", nullable = true)
    private Integer jobId;//岗位ID

    @Column(name = "EMAIL", nullable = true, length = 25)
    private String email;//邮箱

    @Column(name = "PHONE", nullable = true, length = 20)
    private String phone;//手机号

    @Column(name = "AVATAR", nullable = true, length = 255)
    private String avatar;//头像

    @Column(name = "CREATE_TIME", nullable = true)
    private Timestamp createTime;//创建时间

    @Column(name = "UPDATE_TIME", nullable = true)
    private Timestamp updateTime;//修改时间

    @Column(name = "LOCK_FLAG", nullable = true, length = 1)
    private String lockFlag;//0-正常，1-锁定

    @Column(name = "DEL_FLAG", nullable = true, length = 1)
    private String delFlag;//0-正常，1-删除

    /**
     * 角色列表
     */
    @Transient
    private List<SysRole> roleList;
    /**
     * 非数据库字段
     * 部门名称
     */
    @Transient
    private String deptName;
    /**
     * 非数据库字段
     * 岗位名称
     */
    @Transient
    private String jobName;
}
