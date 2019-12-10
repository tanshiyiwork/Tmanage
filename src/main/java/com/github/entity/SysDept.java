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
@Table(name = "SYS_DEPT")
public class SysDept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPT_ID", nullable = false, length = 12)
    private Integer deptId;//部门主键ID

    @Basic
    @Column(name = "DEPT_CODE", nullable = true, length = 100)
    private String deptCode;//部门编号

    @Basic
    @Column(name = "DEPT_NAME", nullable = true, length = 150)
    private String deptName;//部门名称

    @Basic
    @Column(name = "PARENT_ID", nullable = true, length = 12)
    private Integer parentId;//上级部门

    @Basic
    @Column(name = "SORT", nullable = true)
    private Integer sort;//排序

    @Basic
    @Column(name = "LEVEL", nullable = true)
    private Integer level;//层级

    @Basic
    @Column(name = "MOUDLE_ID", nullable = true, length = 50)
    private String moudleId;//模块id

    @Basic
    @Column(name = "CREATE_TIME", nullable = true)
    private Timestamp createTime;

    @Basic
    @Column(name = "UPDATE_TIME", nullable = true)
    private Timestamp updateTime;

    @Basic
    @Column(name = "DEL_FLAG", nullable = true, length = 1)
    private String delFlag;//是否删除  -1：已删除  0：正常

    /**
     * 非数据库字段：子部门信息
     */
    @Transient
    private List<SysDept> childDept;
}
