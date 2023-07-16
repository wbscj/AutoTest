package com.weifeng.fileSplit;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FIleSplit {
    private static String filePath;
    private static int splitNumber;

    public static void main(String[] args) throws IOException {
        verify();
    }

    public static void verify() throws IOException {
        System.out.print("请输入要分割的文件的绝对路径 (例如：D:\\\\1.txt):");
        filePath = new Scanner(System.in).next();
        File file = new File(filePath);
        int count = (int)Files.lines(Paths.get(filePath)).count();

        if (file.length()/1024 > 0){
            System.out.printf("文件大小为：%d KB。\n",file.length()/1024);
        }else if (file.length()/1024 == 0 & count > 0){
            System.out.println("文件小于 1 KB。");
        }else if (!file.isFile()){
            System.out.println("不是可拆分文件或文件不存在，无法拆分！");
            return;
        }else if (count == 0){
            System.out.println("文件为空，无法拆分！");
            return;
        }

        System.out.print("请输入拆分个数：");
        splitNumber = new Scanner(System.in).nextInt();
        while (true){
            if (splitNumber <= 0){
                System.out.print("输入不合法，请重新输入：");
                splitNumber = new Scanner(System.in).nextInt();
            }else {
                break;
            }
        }
        System.out.println();
        split(filePath,splitNumber);
    }

    public static void split(String filePath,int splitNumber) throws IOException {
        File files = new File(filePath);
        //Windows路径   示例D:\\1.txt
        //String folder = files. getParent()+"\\"+files. getName()+"_"+System. currentTimeMillis ();
        //拼接 mac下的 路径
        String folder = files.getParent()+"/"+files.getName().split("\\.")[0]+"_"+System. currentTimeMillis ();
        //创建文件夹
        new File(folder) .mkdirs();
        //获取文件的总行数
        int count = (int)Files.lines(Paths .get(filePath)).count();
        //每个文件的行数
        int every_count = (count/splitNumber);
        String file_name = files.getName().split("\\.")[0];
        //分割交件后缀
        String name_suffix = files.getName().split("\\.")[1];
        //按行读取文件
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(filePath)) ;
        int len = 1;
        Long start_time = System.currentTimeMillis();
        String name_folder = null;
        for (int i = 1; i <= splitNumber; i++){
            //拼接完整的绝对路径
            name_folder = folder + "/" + file_name + "_"+ i + "." + name_suffix;
            FileWriter fileWriter = new FileWriter(name_folder);
            System.out.println("开始写入 "+name_folder);
            while (len <= count){
                String s = lineNumberReader.readLine();
                //如果是最后一行 就不换行了
                if (len == count){
                    fileWriter.write(s);
                //不是最行一行的时候 需要换行，要不就都写成了一行
                }else {
                    fileWriter.write(s+"\n");
                }
                // 不是最后一个文件，且 len 等于每个文件应该写入的行数后，就结束 开始写下一文件
                if (i != splitNumber & len == i*every_count){
                    len++;
                    break;
                }else if (len == count){
                    break;
                }
                len++;
            }
            fileWriter.close();
        }
        System.out.println();
        System.out.printf("拆分后的文件保存于 %s \n",folder );
        long end_time = System.currentTimeMillis();
        System.out.printf("\n拆分结束，耗时：%d 毫秒。",(end_time-start_time));

    }
}
