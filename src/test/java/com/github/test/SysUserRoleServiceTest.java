package com.github.test;

import com.github.entity.SysRole;
import com.github.entity.SysUserRole;
import com.github.service.SysUserRoleService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class SysUserRoleServiceTest {
    private static ApplicationContext applicationContext = null;

    static{
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void testFindUserRoleListByUserId() throws SQLException {
        SysUserRoleService sysUserRoleService = (SysUserRoleService)applicationContext.getBean("sysUserRoleService");
        List<SysUserRole> roles = sysUserRoleService.findUserRoleListByUserId(8);
        roles.stream().forEach(System.out::println);
    }

    @Test
    public void testFindRoleListByUserId() throws SQLException {
        SysUserRoleService sysUserRoleService = (SysUserRoleService)applicationContext.getBean("sysUserRoleService");
        List<SysRole> roles = null;
        try {
            roles = sysUserRoleService.findRoleListByUserId(12);
        } catch (Exception e) {
            e.printStackTrace();
        }
        roles.stream().forEach(System.out::println);
    }
}
