package com.lin.appapidemo.serviceimpl;

import com.lin.appapidemo.model.Position;
import com.lin.appapidemo.service.PositionService;
import com.lin.appapidemo.util.DateTimeUtil;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PositionServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12/28/2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PositionServiceImplTest {
    @Autowired
    private PositionService positionService;
    /**
     * Method: addPosition(Position position)
     */
    @Test
    public void testAddPosition() throws Exception {
        positionService.addPosition(new Position(31,"江苏宿迁泗阳", DateTimeUtil.getDate()));
    }

    /**
     * Method: deletePosition(int pid)
     */
    @Test
    public void testDeletePosition() throws Exception {
        positionService.deletePosition(2);
    }

    /**
     * Method: findAllByUserid(int userid)
     */
    @Test
    public void testFindAllByUserid() throws Exception {
        System.out.println(positionService.findAllByUserid(31).toString());
    }


} 
