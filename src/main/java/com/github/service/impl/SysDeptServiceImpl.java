package com.github.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.github.entity.SysDept;
import com.github.repo.SysDeptRepository;
import com.github.service.SysDeptService;
import com.github.utils.JsonDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<SysDept> sysDepts = sysDeptRepository.findAllByDelFlagIs("0");
        List<JsonDept> jsonDepts = sysDepts.stream().filter(sysDept -> sysDept.getParentId() == 0 || ObjectUtil.isNull(sysDept.getParentId()))
                .map(sysDept -> {
                    JsonDept jsonDept = new JsonDept();
                    jsonDept.setId(sysDept.getDeptId());
                    jsonDept.setText(sysDept.getDeptName());
                    return jsonDept;
                }).collect(Collectors.toList());
        findChildren(jsonDepts,sysDepts);
        return jsonDepts;
    }


    public void findChildren(List<JsonDept> jsonDepts, List<SysDept> depts) {
        for (JsonDept jsonDept : jsonDepts) {
            List<JsonDept> children = new ArrayList<>();
            for (SysDept sysDept : depts) {
                if (jsonDept.getId() == sysDept.getParentId()) {
                    JsonDept jsonDept1 = new JsonDept();
                    jsonDept1.setId(sysDept.getDeptId());
                    jsonDept1.setText(sysDept.getDeptName());
                    children.add(jsonDept1);
                }
            }
            jsonDept.setChildren(children);
            findChildren(children, depts);
        }
    }

}
