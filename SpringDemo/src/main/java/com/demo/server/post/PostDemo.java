package com.demo.server.post;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这里面都是关于post 的请求")
@RequestMapping(value = "/v1")
public class PostDemo {

//    定义一个cookie变量
    public Cookie cookie;
//    通过接口获取cookie
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation( value = "通过接口获取cookie，get请求,url中需要传参")
    public String getCookie(HttpServletResponse response, @RequestParam(value = "username") String UUUsername, @RequestParam Integer password){

        if (UUUsername.equals("zhangsan") && password.equals(123456)){
            this.cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜登录成功！";
        }
         return "登录失败，用户名或密码错误！";
    }
//    带着cookie访问其他接口
    @RequestMapping(value = "/getlist",method = RequestMethod.POST)
    @ApiOperation(value = "带着 cookie 访问，返回列表")
    public String getlist(HttpServletRequest request, @RequestBody User user){
        Cookie[] cookies = request.getCookies();
        for (Cookie c :cookies){
            if (c.getName().equals("login") && c.getValue().equals("true") && user.getUsername().equals("zhangsan") && user.getPassword().equals("123456")){
                User user1 = new User();
                user1.setUsername("lisi");
                user1.setAge(20);
                user1.setUsername("wangwu");
                user1.setAge(30);
                return user1.toString();
            }

        }
        return "权限不足";
    }


}
