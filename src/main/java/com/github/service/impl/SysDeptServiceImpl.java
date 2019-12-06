package com.github.service.impl;

import com.github.entity.SysDept;
import com.github.repo.SysDeptRepository;
import com.github.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sysDeptService")
@Transactional
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptRepository sysDeptRepository;


    @Override
    public SysDept saveSysDept(SysDept sysDept) {
        return sysDeptRepository.save(sysDept);
    }
}