package com.test.Demo1;

import java.util.ResourceBundle;

public class demo2 {

    private String url;
    private ResourceBundle bundle;

    public void beforTest(){
        bundle = ResourceBundle.getBundle("application");
        url = bundle.getString("test.url");
    }


    public void testgetcookie(){
        String result;
        String uri = bundle.getString("uri");

    }
}
