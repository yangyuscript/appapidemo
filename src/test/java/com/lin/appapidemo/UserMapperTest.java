package com.lin.appapidemo;

import com.lin.appapidemo.mapper.UserMapper;
import com.lin.appapidemo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.lin.appapidemo.mapper")
public class UserMapperTest {
    @Autowired(required = false)
    private UserMapper mapper;
    @Test
    public void testInsert(){
        User user=new User("lin2","123","123","123");
        int i=mapper.insert(user);
        System.out.println("hehe"+i);
        Assert.assertNotEquals(0,i);
    }
    @Test
    public void testSelect(){
        User user=mapper.selectByName("lin");
        Assert.assertNotEquals(null,user);
    }
}
