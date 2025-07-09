package com.Controller;

import com.Pojo.Book;
import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getUser", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getUser() {
        System.out.println("获取用户方法被调用..");
        List<Book> list = userService.getUser();
        
        StringBuilder result = new StringBuilder();
        for (Book book : list) {
            result.append("ID: ").append(book.getId())
                  .append("\t 书名: ").append(book.getName())
                  .append("\t 作者: ").append(book.getAuthor())
                  .append("\t 价格: ").append(book.getPrice())
                  .append("\n");
        }
        
        return result.toString();
    }
}
