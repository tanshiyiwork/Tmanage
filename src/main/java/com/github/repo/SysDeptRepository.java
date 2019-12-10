package com.github.repo;

import com.github.entity.SysDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SysDeptRepository extends JpaRepository<SysDept, Integer>, JpaSpecificationExecutor<SysDept> {

    SysDept findSysDeptByDeptIdEqualsAndDelFlagEquals(String deptId,String delFlag);

    public List<SysDept> findAllByParentIdAndDelFlagIs(String parentId,String delFlag);

    public List<SysDept> findAllByParentIdEqualsOrDeptIdAndDelFlag(String parentId,String deptId,String delFlag);
}
