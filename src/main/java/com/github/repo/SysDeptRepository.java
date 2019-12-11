package com.github.repo;

import com.github.entity.SysDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SysDeptRepository extends JpaRepository<SysDept, Integer>, JpaSpecificationExecutor<SysDept> {

    SysDept findSysDeptByDeptIdIsAndDelFlagIs(Integer deptId,String delFlag);

    public List<SysDept> findAllByParentIdIsAndDelFlagIs(Integer parentId,String delFlag);

    public List<SysDept> findAllByParentIdIsOrDeptIdIsAndDelFlagIs(Integer parentId,Integer deptId,String delFlag);
}
