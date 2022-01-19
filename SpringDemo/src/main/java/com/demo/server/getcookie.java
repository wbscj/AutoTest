package com.demo.server;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


@RestController
public class getcookie {
    /***
     * 返回文字信息
     * @return
     */
    @RequestMapping(value = "/cookie",method = RequestMethod.GET)
    public String cookie1(){

        return "获取cookie成功！";
    }

    /***
     * 返回到信息带有cookie
     */
    @RequestMapping(value = "/getcookie",method = RequestMethod.GET)
    public String getcookie1(HttpServletResponse  response){
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "获取cookie成功！";
    }

    /***
     * 带着cookie访问
     * @param request
     * @return
     */
    @RequestMapping(value = "/get/with/cookie",method = RequestMethod.GET)
    public String getwithcookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return "必须带着cookie访问！";
        }

        for (Cookie cookie :cookies){
            if (cookie.getName().equals("log") && cookie.getValue().equals("true")){
                return "恭喜你带着cookie访问成功";
            }
        }
        return "";
    }

}