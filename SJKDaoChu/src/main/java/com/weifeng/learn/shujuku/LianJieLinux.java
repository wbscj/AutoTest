package com.weifeng.learn.shujuku;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LianJieLinux {
    public static void main(String[] args) throws JSchException, IOException {
        JSch jsch = new JSch(); // 创建JSch对象
        Session session = jsch.getSession("wumingyang", "localhost");// 根据用户名，主机ip，端口获取一个Session对象
        session.setPassword("0521"); // 设置密码
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // 为Session对象设置properties
        session.connect(); // 通过Session建立链接

        ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
        channelExec.setCommand("sh /Users/wumingyang/Desktop/mysql/m.sh");
        channelExec.setInputStream(null);
        channelExec.setErrStream(System.err);
        channelExec.connect();

        InputStream in = channelExec.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String buf;
        List<String> fileList = new ArrayList<>();
        while ((buf = reader.readLine()) != null) {
            fileList.add(buf.trim());
        }
        //查看输出结果
        System.out.println("执行结果："+ fileList);


        channelExec.disconnect();
        session.disconnect();

    }
}
