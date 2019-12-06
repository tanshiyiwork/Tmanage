package com.github.repo;

import com.github.entity.SysDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysDeptRepository extends JpaRepository<SysDept, Integer>, JpaSpecificationExecutor<SysDept> {

}
