package com.lin.appapidemo.service;

import com.lin.appapidemo.model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    void deleteBook(int bid);
    void updateBook(Book book);
    Book getByBid(int bid);
    List<Book> findAllWithTerms(String bookname,int condi,String time);
}
