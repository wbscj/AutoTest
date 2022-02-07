package com.demo.server.get;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@RestController
@Api(value = "/",description = "这里的接口都是和get有关的")
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
     * 返回的信息带有cookie
     */
    @RequestMapping(value = "/getcookie",method = RequestMethod.GET)
    @ApiOperation(value = "这是获取cookie 的接口")
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
    @ApiOperation("带着cookie访问")
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

    /***
     *  url中带参数的get请求
     * @param start
     * @param end
     * @return
     */
    @RequestMapping(value = "/getwithmap",method = RequestMethod.GET)
    @ApiOperation(value = "url中带参数的get请求",httpMethod = "GET")
    public Map<String,Integer> getvalue(@RequestParam Integer start,@RequestParam Integer end){
            Map<String,Integer> list = new HashMap<>();
            list.put("方便面",10);
            list.put("矿泉水",4);

            return list;
    }

    @RequestMapping(value = "/getwithmap2/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "url中直接传参数的值",httpMethod = "GET")
    public Map<String,Integer> getvalue2(@PathVariable String start, @PathVariable Integer end){
        Map<String,Integer> list = new HashMap<>();
        list.put("矿泉水",5);
        list.put("瓜子",7);
        list.put("火腿",3);
        return list;

    }


}
