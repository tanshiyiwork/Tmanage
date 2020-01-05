package com.github.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.github.entity.SysRole;
import com.github.entity.SysUserRole;
import com.github.repo.SysUserRoleRepository;
import com.github.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

@Service("sysUserRoleService")
@Transactional
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;


    @Override
    public List<SysUserRole> findUserRoleListByUserId(Integer userId) {
        return sysUserRoleRepository.findAllByUserId(userId);
    }

    @Override
    public List<SysRole> findRoleListByUserId(Integer userId) throws Exception{
        List<Object[]> list = sysUserRoleRepository.selectRoleByUserId(userId);
        List<SysRole> sysRoles = castEntity(list, SysRole.class);
        return sysRoles;
    }

    @Override
    public List<SysUserRole> findUserRoleListByRoleId(Integer roleId) throws Exception {
        return sysUserRoleRepository.findAllByRoleIdIs(roleId);
    }

    //转换实体类
    public static <T> List<T> castEntity(List<Object[]> list, Class<T> clazz) throws Exception {
        List<T> returnList = new ArrayList<T>();
        if(CollectionUtil.isEmpty(list)){
            return returnList;
        }
        Object[] co = list.get(0);
        Class[] c2 = new Class[co.length];
        //确定构造方法
        for (int i = 0; i < co.length; i++) {
            if(co[i]!=null){
                c2[i] = co[i].getClass();
            }else {
                c2[i]=String.class;
            }
        }
        for (Object[] o : list) {
            Constructor<T> constructor = clazz.getConstructor(c2);
            returnList.add(constructor.newInstance(o));
        }
        return returnList;
    }
}
