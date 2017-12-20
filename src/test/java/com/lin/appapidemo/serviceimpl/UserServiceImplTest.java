package com.lin.appapidemo.serviceimpl;

import com.lin.appapidemo.model.User;
import com.lin.appapidemo.service.EmailService;
import com.lin.appapidemo.service.UserService;
import com.lin.appapidemo.util.RedisComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired(required = false)
    private UserService userService;
    @Autowired(required = false)
    private EmailService emailService;
    @Autowired
    private RedisComponent redisComponent;
    @Test
    public void test(){
        userService.addUser(new User("1837475870@qq.com","tony","123","head.jpg",0,0));
    }

    @Test
    public void testEmail(){
        emailService.sendHtmlEmail("1837475870@qq.com","流书账号激活","<a href='https://www.baidu.com/'><h1 style='color:red;'>请点击激活账号</h1></a>");
    }
    @Test
    public void testRedis(){
        //redisComponent.set("Tony3","hehe");
        System.out.println(redisComponent.sentinelGet("C7LMilRFRgG7bqaEq2Rr/g=="));
    }
    @Test
    public void testUserPage(){
        //PageBean<User> page=userService.findUsersByPage(1,2);
        System.out.println(userService.findAll().size());
    }
}