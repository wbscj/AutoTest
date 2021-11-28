package com.lianxi.Testng.Test;

import org.testng.annotations.Test;

public class duoxiancheng1 {

    @Test(invocationCount = 3,threadPoolSize = 3)
    public void test() {
        System.out.println("11111");
        System.out.printf("Thrad Id : %s%n",Thread.currentThread().getId());
    }

}
