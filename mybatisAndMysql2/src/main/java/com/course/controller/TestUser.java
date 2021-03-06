package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


@RestController
@Api(value = "v1",description = "用户管理系统")
@RequestMapping(value = "/v1")
public class TestUser {

    @Autowired
    public  SqlSessionTemplate template;

    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    @ApiOperation(value = "登录接口" ,httpMethod = "POST")
    public Boolean login(HttpServletResponse response, @RequestBody User user){
        int i = template.selectOne("login",user);
        System.out.println("查看到的结果是"+i);
        if (i == 1){
            Cookie cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return true;
        }
        return false;

    }

    private Boolean verifyCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            System.out.println("cookies为空");
            return false;
        }
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("login") &&
                    cookie.getValue().equals("true")){
                System.out.println("cookies验证通过");
                return true;
            }
        }
        return false;
    }

    @ApiOperation(value = "获取用户(列表)信息接口",httpMethod = "POST")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public Object getUserInfo(HttpServletRequest request, @RequestBody User user){
        Boolean x = verifyCookies(request);
        if(x==true){
            List<User> users = template.selectList("getUserInfo",user);
        System.out.println("getUserInfo获取到的用户数量是" +users.size());
            return users;
        }else {

            return "你 没有权限 ！";
        }
    }
}
