package com.github.test;

import com.alibaba.fastjson.JSON;
import com.github.dto.UserDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JsonDataTest {

    @Test
    public void getJsonData(){
        UserDto userDto = new UserDto();
        userDto.setEmail("fdsa");
        List<Integer> roleList = new ArrayList<>();
        roleList.add(1);
        roleList.add(2);
        roleList.add(3);
        userDto.setRoleList(roleList);
        String jsonStr = JSON.toJSONString(userDto);
        System.out.println(jsonStr);
    }
}
