package com.github.service;

import com.alibaba.fastjson.JSONArray;
import com.github.entity.SysDept;

public interface SysDeptService {

    public SysDept saveSysDept(SysDept sysDept);

    public JSONArray getAllJsonDept(String deptId);
}
