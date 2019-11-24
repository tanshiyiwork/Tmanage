package com.github.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Accessors(chain = true)
@Entity
@Table(name = "SYS_USER_ROLE")
public class SysUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IN_ID", nullable = false)
    private Integer inId;

    @Column(name = "USER_ID", nullable = false)
    private Integer userId;

    @Column(name = "ROLE_ID", nullable = false)
    private Integer roleId;

}
