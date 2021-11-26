package com.lianxi.Testng.Test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class chushihua {

    @Test
    @Parameters({"name","age"})
    public void chushihua(String name,int age){
        System.out.println("name ="+name+",  age="+age);

    }
}
