package com.github.service;

import com.github.entity.SysDept;
import com.github.utils.JsonDept;
import com.github.utils.ZtreeNode;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SysDeptService {

    SysDept saveSysDept(SysDept sysDept);

    List<JsonDept> getAllJsonDept();

    List<ZtreeNode> getDpetZtreeNodesById(Integer deptId);

    Page<SysDept> findSysDeptPage(SysDept sysDept,Integer page, Integer rows);
}
