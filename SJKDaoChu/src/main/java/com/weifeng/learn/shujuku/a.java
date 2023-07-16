package com.weifeng.learn.shujuku;

import java.io.FileWriter;
import java.io.IOException;

public class a {
    public static void main(String[] args) throws IOException {
        long  start = System.currentTimeMillis();

        FileWriter fileWriter = new FileWriter("/Users/wumingyang/Desktop/123.txt");
        for (int i = 0; i < 5821414; i++) {
            fileWriter.write(i+"\r\n");
        }
        fileWriter.close();
        long  end = System.currentTimeMillis();
        System.out.println((end-start)/1000);

    }
}
