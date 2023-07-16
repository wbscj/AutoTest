package com.weifeng.wr;

import jdk.management.resource.internal.inst.FileInputStreamRMHooks;

import java.io.*;

public class Reader {
    public static void main(String[] args) throws IOException {
        String path ="/Users/wumingyang/Desktop/a/1.txt";

        File file = new File(path);
        System.out.println("文件名是："+file.getName());
        System.out.println("文件路径是："+file.getPath());



    }
}
