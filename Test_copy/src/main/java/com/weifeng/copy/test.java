package com.weifeng.copy;

import java.io.File;

public class test {
    public static void main(String[] args) {
        String a = "/Users/wumingyang/Desktop/q.txt";
        File file = new File(a);

        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.getName());


    }
}
