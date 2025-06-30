package com.msb.test13;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        //创建一个集合
        ArrayList list = new ArrayList();
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
                System.out.println(">>>展示书籍");
                //对集合进行遍历查看
                for (int i = 0; i <= list.size() -1; i++){
                    Book b = (Book)(list.get(i));
                    System.out.println(b.getbNo() + "----" + b.getbName() + "----" + b.getbAuthor());
                }
            }
            if (choice == 2) {
                System.out.println(">>>上新书籍");
                //从键盘录入书籍信息
                System.out.println("请输入书籍的编号：");
                int bNo = sc.nextInt();
                System.out.println("请输入书籍的名字：");
                String bName = sc.next();
                System.out.println("请输入书籍作者：");
                String bAuthor = sc.next();
                Book b = new Book();
                b.setBno(bNo);
                b.setbName(bName);
                b.setbAuthor(bAuthor);

                list.add(b);//添加个体到集合中去
            }
            if (choice == 3) {
                System.out.println(">>>下架书籍");
                //录入要下架的书籍的编号：
                System.out.println("请录入你要下架的书籍的编号：");
                int delNo = sc.nextInt();
                //下架编号对应的书籍：
                for (int i = 0; i <= list.size() - 1; i++){
                    Book b = (Book)(list.get(i));
                    if (b.getbNo() == delNo){
                        list.remove(b);
                        System.out.println("书籍下架成功");
                        break;//如果下架成功，停止遍历
                    }
                }
            }
            if (choice == 4) {
                System.out.println(">>>退出应用");
                break;
            }
        }
    }
}
