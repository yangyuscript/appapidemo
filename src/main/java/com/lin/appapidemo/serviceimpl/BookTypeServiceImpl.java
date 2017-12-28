package com.lin.appapidemo.serviceimpl;

import com.lin.appapidemo.mapper.BookTypeMapper;
import com.lin.appapidemo.model.BookType;
import com.lin.appapidemo.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired(required = false)
    private BookTypeMapper bookTypeMapper;
    @Override
    public void addBookType(BookType bookType) {
        bookTypeMapper.insert(bookType);
    }

    @Override
    public void deleteByBtid(int btid) {
        bookTypeMapper.deleteByPrimaryKey(btid);
    }

    @Override
    public void updateBookType(BookType bookType) {
        bookTypeMapper.updateByPrimaryKey(bookType);
    }

    @Override
    public List<BookType> findAllWithTerms(String name, String time) {
        return bookTypeMapper.findAllWithTerms(name,time);
    }
}
