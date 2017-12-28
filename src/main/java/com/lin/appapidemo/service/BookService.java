package com.lin.appapidemo.service;

import com.lin.appapidemo.model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    void deleteBook(int bid);
    void updateBook(Book book);
    Book getByBid(int bid);
    /**
     *根据书名、书籍种类、状态、发布时间模糊查找书籍
     *@params:bookname,btid,condi,time
     *@return:List<Book>
     *@date: 10:09 2017/12/28
     **/
    List<Book> findAllWithTerms(String bookname,int btid,int condi,String time);
}
