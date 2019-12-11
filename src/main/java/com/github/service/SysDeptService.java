package com.github.service;

import com.alibaba.fastjson.JSONArray;
import com.github.entity.SysDept;
import com.github.utils.JsonDept;

import java.util.List;

public interface SysDeptService {

    SysDept saveSysDept(SysDept sysDept);

    List<JsonDept> getAllJsonDept(Integer deptId);
}
