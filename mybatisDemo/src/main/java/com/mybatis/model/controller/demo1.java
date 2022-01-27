package com.mybatis.model.controller;

import com.mybatis.model.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
@Api(value = "这里是mybatis的demo")
public class demo1 {

    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "获取user表里的数量",httpMethod = "GET")
    public int getUserCount(){
        int count = template.selectOne("getUserCount");
        return count;
    }

    @RequestMapping(value = "/adduser" ,method = RequestMethod.POST)
    @ApiOperation(value = "添加user 返回数量")
    public int adduser(@RequestBody User user){
        int num = template.insert("addUser",user);
        return num;
    }

    @RequestMapping(value = "/adduser2" ,method = RequestMethod.POST)
    public User adduser2(@RequestBody User user){
        int num = template.insert("addUser",user);
        return user;
    }
}
