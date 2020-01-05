package com.github.test;

import com.github.service.SysDeptService;
import com.github.service.SysUserService;
import com.github.utils.JsonDept;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class SysUserServiceTest {

    private static ApplicationContext applicationContext = null;

    static{
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testInsertUser(){
        SysUserService sysUserService = (SysUserService)applicationContext.getBean("sysUserService");
    }

    @Test
    public void testFindPermsByUserId(){
        SysUserService sysUserService = (SysUserService)applicationContext.getBean("sysUserService");
        Set<String> set = sysUserService.findPermsByUserId(4);
        set.stream().forEach(System.out::println);
    }

    @Test
    public void testFindRoleIdByUserId(){
        SysUserService sysUserService = (SysUserService)applicationContext.getBean("sysUserService");
        Set<String> set1 = sysUserService.findRoleIdByUserId(4);
        set1.stream().forEach(System.out::println);
    }

    @Test
    public void testGetAllJsonDept(){
        SysDeptService sysDeptService = (SysDeptService)applicationContext.getBean("sysDeptService");
        List<JsonDept> jsonDepts = sysDeptService.getAllJsonDept();
        for (JsonDept jsonDept:jsonDepts) {
            System.out.println(jsonDept);
        }
    }
}
