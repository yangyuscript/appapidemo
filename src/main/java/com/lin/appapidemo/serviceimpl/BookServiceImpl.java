package com.lin.appapidemo.serviceimpl;

import com.lin.appapidemo.mapper.BookMapper;
import com.lin.appapidemo.model.Book;
import com.lin.appapidemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService{
    @Autowired(required = false)
    private BookMapper bookMapper;
    @Override
    public void addBook(Book book) {
        bookMapper.insert(book);
    }

    @Override
    public void deleteBook(int bid) {
        bookMapper.deleteByBid(bid);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateByPrimaryKey(book);
    }

    @Override
    public Book getByBid(int bid) {
        return bookMapper.getBookByBid(bid);
    }

    @Override
    public List<Book> findAllWithTerms(String bookname,int btid,int condi,String time) {
        return bookMapper.selectAllWithTerms(bookname,btid,condi,time);
    }
}
