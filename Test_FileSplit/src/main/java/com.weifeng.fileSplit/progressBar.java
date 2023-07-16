package com.weifeng.fileSplit;

import java.util.stream.Stream;

public class progressBar {


    public static void main(String[] args) {
        char incompleter = '*';
        char complete = '&';
        int total = 100;
        StringBuilder builder = new StringBuilder();
        Stream.generate(() -> incompleter).limit(total).forEach(builder::append);
        for (int i = 0; i < total; i++) {
            builder.replace(i,i+1,String.valueOf(complete));
            String progressBar = "\r"+builder;
            String percent = " "+(i+1)+"%";
            System.out.println(progressBar+percent);

            try {
                Thread.sleep(i*5L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }






}
