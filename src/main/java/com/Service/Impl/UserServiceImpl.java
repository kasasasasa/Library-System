package com.Service.Impl;

import com.Mapper.BookMapper;
import com.Pojo.Book;
import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BookMapper userMapper;

    public List<Book> getUser() {
        return userMapper.getUser();
    }
}
