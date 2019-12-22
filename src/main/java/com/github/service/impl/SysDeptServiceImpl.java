package com.github.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.github.entity.SysDept;
import com.github.repo.SysDeptRepository;
import com.github.service.SysDeptService;
import com.github.utils.JsonDept;
import com.github.utils.ZtreeNode;
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
    public List<JsonDept> getAllJsonDept() {
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

    /**
     * 根据部门ID获取下级所以子部门
     * @param deptId
     * @return
     */
    @Override
    public List<ZtreeNode> getDpetZtreeNodesById(Integer deptId) {
        List<SysDept> sysDepts = sysDeptRepository.findAllByDelFlagIs("0");
        List<ZtreeNode> ztreeNodes = sysDepts.stream().filter(sysDept -> sysDept.getDeptId() == deptId)
                .map(sysDept -> {
                    ZtreeNode node = new ZtreeNode();
                    node.setId(sysDept.getDeptId());
                    node.setPid(sysDept.getParentId());
                    node.setName(sysDept.getDeptName());
                    return node;
                }).collect(Collectors.toList());
        findZtreeChildren(ztreeNodes.get(0),sysDepts,ztreeNodes);
        return ztreeNodes;
    }

    @Override
    public Page<SysDept> findSysDeptPage(SysDept sysDept,Integer page, Integer rows) {
        Sort sort = Sort.by(Sort.Direction.DESC,"createTime"); //创建时间降序排序
        Pageable pageable = PageRequest.of(page-1,rows,sort);
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> pr = new ArrayList<>();
                if( sysDept!= null && sysDept.getParentId() != null){
                    pr.add(criteriaBuilder.equal(root.get("parentId").as(Integer.class), sysDept.getParentId()));
                }
                return criteriaBuilder.and(pr.toArray(new Predicate[pr.size()]));
            }
        };
        Page<SysDept> sysDeptPage = sysDeptRepository.findAll(specification,pageable);
        return sysDeptPage;
    }


    public void findZtreeChildren(ZtreeNode node, List<SysDept> depts,List<ZtreeNode> allNodes){
        for (SysDept sysDept : depts){
            if(node.getId() == sysDept.getParentId()){
                ZtreeNode children = new ZtreeNode();
                children.setId(sysDept.getDeptId());
                children.setPid(sysDept.getParentId());
                children.setName(sysDept.getDeptName());
                allNodes.add(children);
                findZtreeChildren(children,depts,allNodes);
            }
        }
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
