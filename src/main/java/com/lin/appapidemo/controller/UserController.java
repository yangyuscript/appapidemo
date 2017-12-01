package com.lin.appapidemo.controller;

import com.lin.appapidemo.model.User;
import com.lin.appapidemo.service.UserService;
import com.lin.appapidemo.util.MD5;
import com.lin.appapidemo.util.ResultMsg;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户注册时，检查邮箱是否已被注册使用
     * @param email
     * @return
     */
    @ApiOperation(value="账号可用性",notes = "判断注册账号是否已被注册使用")
    @RequestMapping(value="/judgeEmail",method=RequestMethod.POST)
    public Map<String,Object> judgeEmail(String email){
        Map<String,Object> map=new HashMap<>();
        boolean flag=userService.isUsedEmail(email);
        if(flag){
            map.put("status", ResultMsg.ok);
        }else{
            map.put("status",ResultMsg.no);
        }
        return map;
    }
    /**
     * 用户注册
     * @param email
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    @ApiOperation(value="用户注册",notes="用户注册，发送邮箱验证")
    @RequestMapping(value="/regist",method = RequestMethod.POST)
    public Map<String, Object> regist(@RequestParam("email")String email,@RequestParam("password")String password)throws NoSuchAlgorithmException,UnsupportedEncodingException{
        Map<String,Object> map=new HashMap<>();
        boolean flag=userService.isUsedEmail(email);
        if(flag){
            //注册账号可使用
            User user=new User(email,email, MD5.EncodeByMD5(password),"head.jpg",0,0);
            map.put("status",ResultMsg.ok);
        }else{
            //注册账号不可用（已被注册使用）
            map.put("msg","账号已被注册使用");
            map.put("status",ResultMsg.no);
        }
        return map;
    }

    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @ApiOperation(value="普通用户登录",notes = "用户登录->判断密码->判断用户状态->生成token")
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public Map<String,Object> login(@RequestParam("email")String email,@RequestParam("password")String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Map<String,Object> map=new HashMap<>();
        User user=userService.checkEmailAndPassword(email,password);
        if(user!=null){
            //账号密码正确，登录成功
            map.put("loginUser",user);
            map.put("status",ResultMsg.ok);
        }else{
            //账号密码有错
            map.put("status",ResultMsg.no);
        }
        return map;
    }
}
