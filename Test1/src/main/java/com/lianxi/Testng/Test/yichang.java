package com.lianxi.Testng.Test;

import org.testng.annotations.Test;

public class yichang {
    @Test(expectedExceptions = RuntimeException.class)
    public void yichang(){
        System.out.println("这是异常测试");
        throw new RuntimeException();
    }
}
