package com.github.utils;

import com.alibaba.fastjson.JSONArray;
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
    private JSONArray children;
    private boolean checked;

    public static JsonDept transt(SysDept sysDept,JSONArray children){
        JsonDept dept = new JsonDept();
        dept.id = sysDept.getDeptId();
        dept.name = sysDept.getDeptName();
        dept.open = true;
        dept.children = children;
        dept.checked = true;
        return dept;
    }
}
