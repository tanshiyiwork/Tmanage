package com.github.service.impl;

import com.github.entity.SysRole;
import com.github.repo.SysRoleRepository;
import com.github.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service("sysRoleService")
@Transactional
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Override
    public void saveOrUpdateSysRole(SysRole sysRole) {
        sysRoleRepository.save(sysRole);
    }

    @Override
    public SysRole findSysRoleByRoleId(Integer roleId,String delflag) {
        return sysRoleRepository.findSysRoleByRoleIdIsAndAndDelFlagIs(roleId,delflag);
    }

    @Override
    public Page<SysRole> findSysRolePage(SysRole sysRole, Integer page, Integer rows) {
        Sort sort = Sort.by(Sort.Direction.DESC,"createTime"); //创建时间降序排序
        Pageable pageable = PageRequest.of(page-1,rows,sort);
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> pr = new ArrayList<>();
                return criteriaBuilder.and(pr.toArray(new Predicate[pr.size()]));
            }
        };
        Page<SysRole> sysRolePage = sysRoleRepository.findAll(specification,pageable);
        return sysRolePage;
    }

    @Override
    public void deleteSysRoleById(Integer roleId) {
        sysRoleRepository.deleteById(roleId);
    }

    @Override
    public List<SysRole> findAllSysRole() {
        return sysRoleRepository.findAllByDelFlagIs("0");
    }
}
