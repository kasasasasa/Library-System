package com.msb.test02;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---欢迎进入图书管理系统---");
            System.out.println("1.根据书籍编号查询书籍信息");
            System.out.println("2.查询所有书籍信息");
            System.out.println("3.删除指定书籍编号对应的书籍");
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
                //查询所有书籍信息
                ArrayList books = findBooks();
                if (books.size() == 0){
                    System.out.println("没有查询到书籍");
                }else {
                    for (int i = 0; i <= books.size()-1; i ++){
                        Book b = (Book) (books.get(i));
                        System.out.println(b.getId() + "----" + b.getName());
                    }
                }
            }
            if (choice == 3) {
                //录入删除的书籍编号
                System.out.println("请输入你想要删除的书籍编号：");
                int bno = sc.nextInt();
                //删除指定书籍编号对应的书籍
                int n = delBookByBno(bno);
                if (n <= 0){
                    System.out.println("删除失败");
                }else {
                    System.out.println("删除成功");
                }
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

    public static ArrayList findBooks() throws ClassNotFoundException, SQLException {
        //定义集合
        ArrayList list = new ArrayList();
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
        ResultSet rs = sta.executeQuery("select * from t_book");
        while (rs.next()){
            //先将结果做接受
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String author = rs.getString("author");
            Double price = rs.getDouble("price");
            //将上面的数据封装为一个Book对象
            Book b = new Book();
            b.setId(id);
            b.setName(name);
            b.setAuthor(author);
            b.setPrice(price);

            //将书籍放入集合中
            list.add(b);
        }
        //关闭资源
        sta.close();
        conn.close();

        return list;
    }

    public static int delBookByBno(int bno) throws ClassNotFoundException, SQLException {
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
        int n = sta.executeUpdate("delete from t_book where id = " +  bno );

        //关闭资源
        sta.close();
        conn.close();

        return n;
    }
}
