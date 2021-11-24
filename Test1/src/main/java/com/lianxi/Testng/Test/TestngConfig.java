package com.lianxi.Testng.Test;

import org.testng.annotations.*;

@Test(groups = "1")
public class TestngConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite 运行");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite 运行了");
    }


    @BeforeTest
    public void beforetest(){
        System.out.println("beforetest 运行了");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("AfterTest 运行了");
    }

    @BeforeGroups
    public void beforgroups(){
        System.out.println("BeforeGroups  运行了");
    }

    @AfterGroups
    public void aftergtoups(){
        System.out.println("AfterGroups 运行了");
    }
}
