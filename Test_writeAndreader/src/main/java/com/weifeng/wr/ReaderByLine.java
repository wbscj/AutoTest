package com.weifeng.wr;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReaderByLine {
    public static void main(String[] args) throws IOException {
    l();
    }

    public static void l() throws IOException {
        String p = "/Users/wumingyang/Desktop/a/1.txt";

        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(p));

        int lines = (int)Files.lines(Paths.get(p)).count();
        System.out.printf("文件共有 %s 行。\n",lines);

        for (int i = 0; i < lines; i++) {
            System.out.println(lineNumberReader.readLine());
        }
    }

}
