package com.lin.appapidemo.service;

import com.lin.appapidemo.model.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {
    public void addUser(User user);

    /**
     * 判断注册邮箱是否已被注册
     * @param email
     * @return
     */
    public boolean isUsedEmail(String email);

    /**
     * 判断用户登录时的账号和密码是否正确
     * @param email
     * @param password
     * @return
     */
    public User checkEmailAndPassword(String email,String password) throws UnsupportedEncodingException, NoSuchAlgorithmException;
    /**
     *获得所有用户信息
     *@params:
     *@return:List
     *@date: 18:24 2017/12/11
     **/
    public List<User> findAll();
}
