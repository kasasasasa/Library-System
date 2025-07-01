package com.msb.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/msb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url,username,password);
        //创建会话
        Statement sta = conn.createStatement();
        //发送SQL：
        int i = sta.executeUpdate("insert into t_book (id,name,author,price) values(2,'红高粱','莫言',49)");
        if (i > 0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }

        //关闭资源
        sta.close();
        conn.close();
    }
}
