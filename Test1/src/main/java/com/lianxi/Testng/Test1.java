package com.lianxi.Testng;

import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void test1(){
        System.out.println("test111111 运行了");
        System.out.printf("test111111  运行 ，Thrad Id : %s%n",Thread.currentThread().getId());
    }
}
