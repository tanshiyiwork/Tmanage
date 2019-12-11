package com.github.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.github.entity.SysDept;
import com.github.repo.SysDeptRepository;
import com.github.service.SysDeptService;
import com.github.utils.JsonDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<JsonDept> getAllJsonDept(Integer deptId) {
        List<JsonDept> jsonDepts = new ArrayList<>();
        SysDept dept = sysDeptRepository.findSysDeptByDeptIdIsAndDelFlagIs(deptId,"0");
        if(null != dept){
            jsonDepts.add(JsonDept.transfer(dept));
            this.getJsonDept(dept,jsonDepts);
        }
        return jsonDepts;
    }

    private List<JsonDept> getJsonDept(SysDept sysDept,List<JsonDept> jsonDepts){
        List<SysDept> sysChildren = sysDeptRepository.findAllByParentIdIsAndDelFlagIs(sysDept.getDeptId(),"0");
        if(null != sysChildren && sysChildren.size()>0){
            for (SysDept deptInfo:sysChildren) {
                jsonDepts.add(JsonDept.transfer(deptInfo));
                getJsonDept(deptInfo,jsonDepts);
            }
        }
        return jsonDepts;
    }
}
