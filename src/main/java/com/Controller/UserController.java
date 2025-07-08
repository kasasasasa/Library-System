package com.Controller;

import com.Pojo.Book;
import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public List<Book> getUser() {
        System.out.println("获取用户方法被调用..");
        List<Book> list = userService.getUser();
        return list;
    }
}
