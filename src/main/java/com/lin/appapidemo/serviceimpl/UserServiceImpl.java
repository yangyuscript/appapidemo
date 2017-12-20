package com.lin.appapidemo.serviceimpl;

import com.lin.appapidemo.mapper.UserMapper;
import com.lin.appapidemo.model.User;
import com.lin.appapidemo.service.UserService;
import com.lin.appapidemo.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public boolean isUsedEmail(String email) {
        User user=userMapper.selectByEmail(email);
        if(user==null){
            //注册账号未被使用，可用
            return true;
        }
        //注册账号已被使用，不可用
        return false;
    }

    @Override
    public User checkEmailAndPassword(String email, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        User user=userMapper.selectByEmail(email);
        if(user!=null) {
            if(user.getPassword().equals(MD5.EncodeByMD5(password))){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

}
