package com.github.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.github.entity.SysDept;
import com.github.repo.SysDeptRepository;
import com.github.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sysDeptService")
@Transactional
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptRepository sysDeptRepository;


    @Override
    public SysDept saveSysDept(SysDept sysDept) {
        return sysDeptRepository.save(sysDept);
    }

    @Override
    public JSONArray getAllJsonDept(String deptId) {
        List<SysDept> sysDepts =sysDeptRepository.findAllByParentIdEqualsOrDeptIdAndDelFlag(deptId,deptId,"0");
        return null;
    }

    private JSONArray getJsonDept(String deptId){
        JSONArray jsonArray = new JSONArray();
        SysDept dept = sysDeptRepository.findSysDeptByDeptIdEqualsAndDelFlagEquals(deptId,"0");
        List<SysDept> children = sysDeptRepository.findAllByParentIdAndDelFlagIs(deptId,"0");
        return jsonArray;
    }
}
