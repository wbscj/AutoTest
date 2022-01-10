package com.test.Demo1;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class PostWithCookieAndJson {

    private ResourceBundle bundle;
    private String url;
    private CookieStore cookieStore;

    @BeforeTest
    public void testbefore(){
        bundle = ResourceBundle.getBundle("application");
        url = bundle.getString("test.url");
    }

    @Test
    public void getcookie() throws IOException {
        String result;
        String uri = bundle.getString("uri");
        String url = this.url+uri;
        System.out.println("访问的地址为："+url);

        HttpGet get = new HttpGet(url);

        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        cookieStore = client.getCookieStore();
        List<Cookie> cookieList = cookieStore.getCookies();

        for (Cookie cookie:cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("获取打的cookie 为："+name+"；"+value);
        }

    }


    @Test(dependsOnMethods = {"getcookie"})
    public void postwithcookie() throws IOException {
        String uri = bundle.getString("uri_postwithcookie");
        String url = this.url+uri;
        System.out.println("访问的地址为："+url);

        HttpPost post = new HttpPost(url);

        DefaultHttpClient HttpClent = new DefaultHttpClient();

        JSONObject json = new JSONObject();
        json.put("name","zhangsan");
        json.put("age","20");

        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(json.toString(),"utf-8");
        post.setEntity(entity);

        String result;
        HttpClent.setCookieStore(cookieStore);

        HttpResponse httpResponse = HttpClent.execute(post);

        result = EntityUtils.toString(httpResponse.getEntity(),"Utf-8");
        System.out.println(result);

        JSONObject resultjson = new JSONObject(result);
        String name = (String) resultjson.get("name");
        int age = (Integer) resultjson.get("age");
        System.out.println("这是获取到的json参数："+ "name:"+name+",age:"+age);


    }
}
