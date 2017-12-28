package com.lin.appapidemo.serviceimpl;

import com.lin.appapidemo.model.BookType;
import com.lin.appapidemo.service.BookTypeService;
import com.lin.appapidemo.util.DateTimeUtil;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * BookTypeServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12/28/2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTypeServiceImplTest {
    @Autowired
    private BookTypeService bookTypeService;
    /**
     * Method: addBookType(BookType bookType)
     */
    @Test
    public void testAddBookType() throws Exception {
        bookTypeService.addBookType(new BookType("算法",DateTimeUtil.getDate()));
    }

    /**
     * Method: deleteByBtid(int btid)
     */
    @Test
    public void testDeleteByBtid() throws Exception {
        bookTypeService.deleteByBtid(3);
    }

    /**
     * Method: updateBookType(BookType bookType)
     */
    @Test
    public void testUpdateBookType() throws Exception {

    }

    /**
     * Method: findAllWithTerms(String name, String time)
     */
    @Test
    public void testFindAllWithTerms() throws Exception {
        System.out.println(bookTypeService.findAllWithTerms("算",null).toString());
    }


} 
