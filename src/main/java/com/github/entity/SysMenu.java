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
@Table(name = "SYS_MENU")
public class SysMenu {

    /**
     * 菜单ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ID", nullable = false)
    private Integer menuId;

    /**
     * 菜单名称
     */
    @Column(name = "NAME", nullable = false, length = 32)
    private String name;

    /**
     * 菜单权限标识
     */
    @Column(name = "PERMS", nullable = true, length = 32)
    private String perms;

    /**
     * 前端path / 即跳转路由
     */
    @Column(name = "PATH", nullable = true, length = 128)
    private String path;

    /**
     * 菜单组件
     */
    @Column(name = "COMPONENT", nullable = true, length = 255)
    private String component;

    /**
     * 父菜单ID
     */
    @Column(name = "PARENT_ID", nullable = true)
    private Integer parentId;

    /**
     * 图标
     */
    @Column(name = "ICON", nullable = true, length = 32)
    private String icon;

    /**
     * 排序
     */
    @Column(name = "SORT", nullable = true)
    private Integer sort;

    /**
     * 菜单类型 （类型   0：目录   1：菜单   2：按钮）
     */
    @Column(name = "TYPE", nullable = true)
    private Integer type;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME", nullable = true)
    private Timestamp createTime;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME", nullable = true)
    private Timestamp updateTime;

    /**
     * 逻辑删除标记(0--正常 1--删除)
     */
    @Column(name = "DEL_FLAG", nullable = true, length = 1)
    private String delFlag;

    /**
     * 是否为外链
     */
    @Column(name = "IS_FRAME", nullable = true)
    private Byte isFrame;

    /**
     * 非数据库字段
     * 父菜单名称
     */
    @Transient
    private String parentName;

    /**
     * 非数据库字段
     * 菜单等级
     */
    @Transient
    private Integer level;

    /**
     * 非数据库字段
     * 子菜单
     */
    @Transient
    private List<SysMenu> children;
}
