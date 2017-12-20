package com.lin.appapidemo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.appapidemo.model.User;
import com.lin.appapidemo.service.UserService;
import com.lin.appapidemo.util.ResultMsg;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/super")
public class SuperController {
    @Autowired
    private UserService userService;

    /**
     *管理员获得所有用户信息
     *@params:
     *@return:List
     *@date: 18:27 2017/12/11
     **/
    @ApiOperation(value = "获得所有用户信息",notes = "管理员权限,一页默认10个记录")
    @RequestMapping(value="/getAllUserInfo",method = RequestMethod.GET)
    public Map<String,Object> getAllUserInfo(){
        Map<String,Object> map=new HashMap<>();
        PageHelper.startPage(ResultMsg.CURRENTPAGE,ResultMsg.PAGESIZE);
        List<User> list=userService.findAll();
        PageInfo<User> pageInfo=new PageInfo<>(list);
        map.put("users",list);
        map.put("status", ResultMsg.ok);
        return map;
    }
}
