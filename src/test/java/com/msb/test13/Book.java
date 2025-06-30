package com.msb.test13;

public class Book {
    //书籍编号
    private int bNo;
    //书籍名称
    private String bName;
    //书籍作者
    private String bAuthor;

    public Book(int bNo,String bName,String bAuthor) {
        this.bNo = bNo;
        this.bName = bName;
        this.bAuthor = bAuthor;
    }

    public Book() {

    }

    public int getbNo(){
        return bNo;
    }
    public void setBno(int bNo){
        this.bNo = bNo;
    }
    public String getbName(){
        return bName;
    }
    public void setbName(String bName){
        this.bName = bName;
    }
    public String getbAuthor(){
        return bAuthor;
    }
    public void setbAuthor(String bAuthor){
        this.bAuthor = bAuthor;
    }

}
