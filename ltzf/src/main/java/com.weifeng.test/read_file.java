package com.weifeng.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @description：TODO
 * @USER ：weifeng
 * @date ：2025/1/21 上午 10:54
 */
public class read_file {
    public static void main(String[] args) throws IOException {
        String filePath = "E:\\JAVA\\java练习\\AutoTest\\ltzf\\t_applet_store_202501211014.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            // 打印每一行的内容
            System.out.println(line);
        }
    }
}
