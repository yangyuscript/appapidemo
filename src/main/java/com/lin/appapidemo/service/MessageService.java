package com.lin.appapidemo.service;

import com.lin.appapidemo.model.Message;

import java.util.List;

public interface MessageService {
    void addMessage(Message message);
    void deleteMessage(int mid);
    List<Message> findAllByTouserid(int touserid);
    List<Message> findAllByTouseridAndFromuserid(int touserid,int fromuserid);
}
