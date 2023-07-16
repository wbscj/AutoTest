package com.weifeng.wr;

import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public static void main(String[] args) throws IOException {
        String f = "/Users/wumingyang/Desktop/测试数据.csv";
        int n = 1000000;

        FileWriter fileWriter = new FileWriter(f);

        for (int i = 1; i < n+1; i++) {
            if (i == n){
                fileWriter.write("TEST"+i);
            }else {
                fileWriter.write("TEST"+i+"\n");
            }

        }
        fileWriter.close();

    }
}
