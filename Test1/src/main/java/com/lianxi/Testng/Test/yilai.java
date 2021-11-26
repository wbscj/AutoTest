package com.lianxi.Testng.Test;

import org.testng.annotations.Test;

public class yilai {
    @Test
    public void test1(){
        System.out.println("这是 test2的前置");
        throw new RuntimeException();
    }
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 运行");
    }
}
