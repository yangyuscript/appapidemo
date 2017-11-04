package com.lin.appapidemo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @ApiOperation(value="api首页demo",notes="6666")
    @RequestMapping(value="index",method = RequestMethod.GET)
    public String index(){
        return "hello world!";
    }
}
