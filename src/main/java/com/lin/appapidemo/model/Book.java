package com.lin.appapidemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@NoArgsConstructor
@Accessors(chain=true)
@Table(name="t_book")
public class Book {
    @Column(name="bid")
    private int bid;
    @Column(name="userid")
    private int userid;
    @Column(name="bookname")
    private String bookname;
    @Column(name="bookpic")
    private String bookpic;
    @Column(name="description")
    private String description;
    @Column(name="condi")
    private int condi;
    @Column(name="time")
    private String time;
    //不是表中字段需要加此注解（在使用tkmybatis时）
    @Transient
    private User user;

    public Book(int userid, String bookname, String bookpic, String description, int condi, String time) {
        this.userid = userid;
        this.bookname = bookname;
        this.bookpic = bookpic;
        this.description = description;
        this.condi = condi;
        this.time = time;
    }
}
