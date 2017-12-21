package com.lin.appapidemo.serviceimpl;

import com.lin.appapidemo.model.Book;
import com.lin.appapidemo.service.BookService;
import com.lin.appapidemo.util.DateTimeUtil;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * BookServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12/21/2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceImplTest {
    @Autowired
    private BookService bookService;

    /**
     * Method: addBook(Book book)
     */
    @Test
    public void testAddBook() throws Exception {
        bookService.addBook(new Book(31,"testbook2","test2.jpg","test2",1, DateTimeUtil.getDate()));
    }

    /**
     * Method: deleteBook(int bid)
     */
    @Test
    public void testDeleteBook() throws Exception {

    }

    /**
     * Method: updateBook(Book book)
     */
    @Test
    public void testUpdateBook() throws Exception {

    }

    /**
     * Method: getByBid(int bid)
     */
    @Test
    public void testGetByBid() throws Exception {

    }

    /**
     * Method: findAll()
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println(bookService.findAllWithTerms(null,2,"9").toString());
    }


} 
