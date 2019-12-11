package com.github.utils;

import com.alibaba.fastjson.JSONObject;
import com.github.entity.SysDept;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class JsonDept {

    private Integer id;
    private String name;
    private boolean open;
    private Integer pid;
    private boolean checked;

    public static JsonDept transfer(SysDept sysDept){
        JsonDept dept = new JsonDept();
        dept.id = sysDept.getDeptId();
        dept.name = sysDept.getDeptName();
        dept.open = true;
        dept.pid = sysDept.getParentId();
        dept.checked = true;
        return dept;
    }

}
