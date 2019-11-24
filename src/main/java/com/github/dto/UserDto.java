package com.github.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Integer userId;
    private String username;
    private String password;
    private Integer deptId;
    private Integer jobId;
    private String phone;
    private String email;
    private String avatar;
    private String lockFlag;
    private String delFlag;
    private List<Integer> roleList;
    private List<Integer> deptList;
    /**
     * 新密码
     */
    private String newPassword;
}
