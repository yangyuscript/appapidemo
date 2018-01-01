package com.lin.appapidemo.serviceimpl;

import com.lin.appapidemo.mapper.NoticeMapper;
import com.lin.appapidemo.model.Notice;
import com.lin.appapidemo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{
    @Autowired(required = false)
    private NoticeMapper noticeMapper;
    @Override
    public void addNotice(Notice notice) {
        noticeMapper.insert(notice);
    }

    @Override
    public void deleteNotice(int nid) {
        noticeMapper.deleteByPrimaryKey(nid);
    }

    @Override
    public List<Notice> findAll() {
        return noticeMapper.selectAll();
    }
}
