package com.github.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {

    private Integer userId;//主键ID
    private String username;//用户名
    private String password;//密码
    private Integer deptId;//部门ID
    private Integer jobId;//岗位ID
    private String phone;//手机号
    private String email;//邮箱
    private String avatar;//头像
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
    private String lockFlag;//0-正常，1-锁定
    private String delFlag;//0-正常，1-删除
    private List<Integer> roleList;
    /**
     * 新密码
     */
    private String newPassword;

    /**
     * 多个角色id拼接字符串
     */
    private String roleIds;
}
