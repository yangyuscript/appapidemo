package com.lin.appapidemo;

import com.lin.appapidemo.mapper.BookMapper;
import com.lin.appapidemo.mapper.UserMapper;
import com.lin.appapidemo.mapper.shixun.AlbumMapper;
import com.lin.appapidemo.mapper.shixun.BorrowrecordMapper;
import com.lin.appapidemo.mapper.shixun.ReaderMapper;
import com.lin.appapidemo.mapper.shixun.SubalbumMapper;
import com.lin.appapidemo.model.Book;
import com.lin.appapidemo.model.User;
import com.lin.appapidemo.model.shixun.Album;
import com.lin.appapidemo.model.shixun.Borrowrecord;
import com.lin.appapidemo.model.shixun.Reader;
import com.lin.appapidemo.model.shixun.Subalbum;
import com.lin.appapidemo.util.DateTimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.lin.appapidemo.mapper")
public class UserMapperTest {
    @Autowired(required = false)
    private UserMapper mapper;
    @Autowired(required = false)
    private BookMapper bookMapper;
    @Autowired(required = false)
    private ReaderMapper readerMapper;
    @Autowired(required = false)
    private AlbumMapper albumMapper;
    @Autowired(required = false)
    private SubalbumMapper subalbumMapper;
    @Autowired(required = false)
    private BorrowrecordMapper borrowrecordMapper;
    @Test
    public void testInsert(){
        //User user=new User("lin2","123","123","123",123 ,1);
        //int i=mapper.insert(user);
        //bookMapper.insert(new Book(1,"testbook","test.jpg","test",1, DateTimeUtil.getDate()));
        //readerMapper.insert(new Reader("B14041526","123","林光翔","男",DateTimeUtil.getDate(),0));
        //albumMapper.insert(new Album("测试书名","测试作者","工业出版社",DateTimeUtil.getDate(),0,"测试描述",DateTimeUtil.getDate()));
        //subalbumMapper.insert(new Subalbum(1,DateTimeUtil.getDateNumber(),0,DateTimeUtil.getDate()));
        borrowrecordMapper.insert(new Borrowrecord(1,"B14041526",1,1,DateTimeUtil.getDate(),DateTimeUtil.getDateNumber()));
    }
    @Test
    public void testSelect(){
        //User user=mapper.selectByName("test@qq.com");
        //System.out.println(user.getNickname());
        System.out.println(readerMapper.selectByAccount("B"));
    }
}
