package com.github.test;

import com.github.dto.UserDto;
import com.github.service.SysUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
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
        UserDto userDto = new UserDto();
        userDto.setUserId(1);
        userDto.setUsername("lucy");
        userDto.setAvatar("avatar");
        userDto.setDelFlag("0");
        userDto.setDeptId(1);
        userDto.setEmail("123@qq.com");
        userDto.setPhone("15478954565");
        userDto.setPassword("12345");
        List<Integer> roleList = new ArrayList<Integer>();
        roleList.add(1);
        roleList.add(2);
        roleList.add(3);
        userDto.setRoleList(roleList);
        sysUserService.insertUser(userDto);
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
}
