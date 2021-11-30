package com.lianxi.Testng.Test;

import org.testng.annotations.Test;

public class timeout {
    @Test(timeOut = 1000)
    public void test() throws InterruptedException {
        Thread.sleep(2000);
    }
}
