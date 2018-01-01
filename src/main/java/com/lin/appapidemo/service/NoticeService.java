package com.lin.appapidemo.service;

import com.lin.appapidemo.model.Notice;

import java.util.List;

public interface NoticeService {
    void addNotice(Notice notice);
    void deleteNotice(int nid);
    List<Notice> findAll();
}
