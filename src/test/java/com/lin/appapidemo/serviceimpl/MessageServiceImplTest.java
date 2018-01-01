package com.lin.appapidemo.serviceimpl;

import com.lin.appapidemo.model.Message;
import com.lin.appapidemo.service.MessageService;
import com.lin.appapidemo.util.DateTimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * MessageServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12/28/2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceImplTest {
    @Autowired
    private MessageService messageService;
    /**
     * Method: addMessage(Message message)
     */
    @Test
    public void testAddMessage() throws Exception {
        messageService.addMessage(new Message(31,30,"不告诉你？哈哈",0, DateTimeUtil.getDate()));
    }

    /**
     * Method: deleteMessage(int mid)
     */
    @Test
    public void testDeleteMessage() throws Exception {

    }

    /**
     * Method: findAllByTouserid(int touserid)
     */
    @Test
    public void testFindAllByTouserid() throws Exception {
        System.out.println(messageService.findAllByTouserid(30).toString());
    }

    /**
     * Method: findAllByTouseridAndFromuserid(int touserid, int fromuserid)
     */
    @Test
    public void testFindAllByTouseridAndFromuserid() throws Exception {
        System.out.println(messageService.findAllByTouseridAndFromuserid(30,31).toString());
    }


} 
