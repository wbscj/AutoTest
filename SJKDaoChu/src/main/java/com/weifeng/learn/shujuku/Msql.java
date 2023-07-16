package com.weifeng.learn.shujuku;

import java.io.*;
import java.sql.*;

public class Msql {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        run();

    }

    public static void run() throws ClassNotFoundException, SQLException, IOException {


        // 加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 创建数据库连接
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_mybatis", "root", "qwer1234");
        // 创建Statement对象
        Statement stmt = con.createStatement();
        // 查询数据得到ResultSet结果集
        String sql = "SELECT userName FROM `user`";

        ResultSet rs = stmt.executeQuery(sql);
        long  start = System.currentTimeMillis();
        FileWriter fileWriter = new FileWriter("/Users/wumingyang/Desktop/data.txt");
        while (rs.next()){
            fileWriter.write(rs.getString("userName")+"\r\n");
        }
        fileWriter.close();
        long  end = System.currentTimeMillis();
        System.out.println((end-start)/1000+"s");


//        for (int i = 2664917; i < 10000000; i++) {
//            String sql = "INSERT INTO `test_mybatis`.`user`(`id`, `userName`, `password`, `age`, `sex`, `permission`, `inDelete`) VALUES ("+i+","+ i+", '22', 4, '1', '1', '0');";
//            stmt.execute(sql);
//        }

        con.close();

        // 创建文件输出流和数据输出流
//        FileOutputStream fos = new FileOutputStream("/Users/wumingyang/Desktop/data.txt");
//        DataOutputStream dos = new DataOutputStream(fos);
//        // 遍历结果集，将数据写入文件
//        while (rs.next()) {
//            dos.writeUTF(rs.getString("userName")+"\r\n");
//            // ...
//        }
//        // 关闭数据输出流和文件输出流
//        dos.close();
//        fos.close();
    }
}
