package com.Test.testng;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

public class Test1 {
    @Test
    public void test1(){
        String a = "1";
        a.equals(1);
    }
    @Test
    public void test2(){
        String a = "1";
        a.equals("1");
    }
    @Test
    public void test3(){
        Assert.assertEquals(1,2);
    }


    @Test
    public void Log(){
        Reporter.log("这是我自己定义的日志");
        throw new RuntimeException("这是我自己定义的异常");
    }

    private String url;
    private ResourceBundle bundle;
    private CookieStore cookieStore ;
    @BeforeTest
    public void beforTest(){
        bundle = ResourceBundle.getBundle("application");
        url = bundle.getString("test.url");
    }

    @Test
    public void testgetcookie() throws IOException {
//        在配置文件中获取参数拼接url
        String result;
        String uri = bundle.getString("uri");
        String u = url + uri;
        System.out.println("访问的url为："+u);
        HttpGet get = new HttpGet(u);

        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        this.cookieStore = client.getCookieStore();
        List<Cookie> cooklist = cookieStore.getCookies();
//        for(Cookie cookie:cooklist){
//            String name = cookie.getName();
//            String value = cookie.getValue();
//
//            System.out.println("CookieName :"+ name);
//            System.out.println("CookieValue :"+ value);
//        }

        ListIterator<Cookie> list = cooklist.listIterator();
        while (list.hasNext()){
            Cookie c = list.next();
            System.out.println(c.getName());
            System.out.println(c.getValue());
        }
    }

    @Test(dependsOnMethods = {"testgetcookie"})
    public void getAndcookie() throws IOException {
        String uri = bundle.getString("uri_get");
        url = url+uri;
        System.out.println("访问的url为："+url);

        HttpGet httpGet = new HttpGet(url);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        defaultHttpClient.setCookieStore(this.cookieStore);

        CloseableHttpResponse response = defaultHttpClient.execute(httpGet);
        int StatusCode = response.getStatusLine().getStatusCode();
        System.out.println("状态码为："+StatusCode);
        if (StatusCode == 200){
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println("返回信息为："+result);
        }

    }

}
