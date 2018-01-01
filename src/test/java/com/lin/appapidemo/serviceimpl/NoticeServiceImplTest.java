package com.lin.appapidemo.serviceimpl;

import com.lin.appapidemo.model.Notice;
import com.lin.appapidemo.service.NoticeService;
import com.lin.appapidemo.util.DateTimeUtil;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * NoticeServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>01/01/2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeServiceImplTest {
    @Autowired
    private NoticeService noticeService;
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: addNotice(Notice notice)
     */
    @Test
    public void testAddNotice() throws Exception {
        noticeService.addNotice(new Notice("测试公告","测试公告内容",0, DateTimeUtil.getDate()));
    }

    /**
     * Method: deleteNotice(int nid)
     */
    @Test
    public void testDeleteNotice() throws Exception {
        noticeService.deleteNotice(2);
    }

    /**
     * Method: findAll()
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println(noticeService.findAll());
    }


} 
