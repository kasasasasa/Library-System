package com.msb.test02;

import java.sql.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---欢迎进入图书管理系统---");
            System.out.println("1.展示书籍");
            System.out.println("2.上新书籍");
            System.out.println("3.下架书籍");
            System.out.println("4.退出应用");
            System.out.println("请输入你想要执行的功能：");
            int choice = sc.nextInt();
            if (choice == 1) {
                //键盘录入书籍编号
                System.out.println("请输入你想要查看的书籍编号：");
                int bno = sc.nextInt();
                //根据编号查询对应的书籍
                Book b = findBookByBno(bno);
                //通过b的结果来判定书籍是否查询到
                if(b == null){
                    System.out.println("你查询的书籍不存在");
                }else {
                    System.out.println("当前查询到一本书：《" + b.getName() + "》");
                }
            }
            if (choice == 2) {

            }
            if (choice == 3) {

            }
            if (choice == 4) {
                System.out.println(">>>退出应用");
                break;
            }
        }
    }

    public static Book findBookByBno(int bno) throws ClassNotFoundException, SQLException {
        Book b = null;
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
        ResultSet rs = sta.executeQuery("select * from t_book where id = " + bno);
        if (rs.next()){//如果结果只有一条，想要获取的话，写if就可以
            //先将结果做接受
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String author = rs.getString("author");
            Double price = rs.getDouble("price");
            //将上面的数据封装为一个Book对象
            b = new Book();
            b.setId(id);
            b.setName(name);
            b.setAuthor(author);
            b.setPrice(price);
        }
        //关闭资源
        sta.close();
        conn.close();

        return b;
    }
}
