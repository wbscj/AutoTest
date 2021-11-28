package com.lianxi.Testng.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class chushihua2 {

    @Test(dataProvider = "test")
    public void test(String name,int age){
        System.out.println("test    name="+name+", age="+age);
    }

    @DataProvider(name = "test")
    public Object[] [] methodDateTest(){
        Object[] [] o= new Object[] []{
                {"zhangsan",20}
        };
        return o;
    }


    @Test(dataProvider = "data")
    public void test1(String name,int age){
        System.out.println("test111    name="+name+", age="+age);
    }

    @Test(dataProvider = "data")
    public void test2(String name,int age){
        System.out.println("test222    name="+name+", age="+age);
    }

    @DataProvider(name = "data")
    public Object[] [] data(Method method){
        Object[] [] o = null;
        if (method.getName().equals("test1")){
            o = new Object[] [] {
                {"zhangsan",20}
            };
        }
        else if (method.getName().equals("test2")){
            o = new Object[] [] {
                {"lisi",30}
            };
        }
        return o;
    }

}
