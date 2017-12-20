package com.lin.appapidemo;

import com.lin.appapidemo.mapper.BookMapper;
import com.lin.appapidemo.mapper.UserMapper;
import com.lin.appapidemo.model.Book;
import com.lin.appapidemo.model.User;
import com.lin.appapidemo.util.DateTimeUtil;
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
    @Autowired(required = false)
    private BookMapper bookMapper;
    @Test
    public void testInsert(){
        //User user=new User("lin2","123","123","123",123 ,1);
        //int i=mapper.insert(user);
        //bookMapper.insert(new Book(1,"testbook","test.jpg","test",1, DateTimeUtil.getDate()));
    }
    @Test
    public void testSelect(){
        //User user=mapper.selectByName("test@qq.com");
        //System.out.println(user.getNickname());
        System.out.println(bookMapper.getBookByBid(1).toString());
    }
}
