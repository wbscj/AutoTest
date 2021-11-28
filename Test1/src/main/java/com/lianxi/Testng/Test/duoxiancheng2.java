package com.lianxi.Testng.Test;

import org.testng.annotations.Test;

public class duoxiancheng2 {
    @Test
    public void test1(){
        System.out.printf("test1  运行 ，Thrad Id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.printf("test2  运行 ，Thrad Id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.printf("test3  运行 ，Thrad Id : %s%n",Thread.currentThread().getId());
    }
}
