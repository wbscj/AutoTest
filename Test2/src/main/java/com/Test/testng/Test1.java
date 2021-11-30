package com.Test.testng;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

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


}
