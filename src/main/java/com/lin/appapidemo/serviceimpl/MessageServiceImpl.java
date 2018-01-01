package com.lin.appapidemo.serviceimpl;

import com.lin.appapidemo.mapper.MessageMapper;
import com.lin.appapidemo.model.Message;
import com.lin.appapidemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired(required = false)
    private MessageMapper messageMapper;
    @Override
    public void addMessage(Message message) {
        messageMapper.insert(message);
    }

    @Override
    public void deleteMessage(int mid) {
        messageMapper.deleteByPrimaryKey(mid);
    }

    @Override
    public List<Message> findAllByTouserid(int touserid) {
        return messageMapper.findAllByTouserid(touserid);
    }

    @Override
    public List<Message> findAllByTouseridAndFromuserid(int touserid, int fromuserid) {
        return messageMapper.findAllByTouseridAndFromuserid(touserid,fromuserid);
    }
}
