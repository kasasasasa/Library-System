package com.Mapper;

import com.Pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("select * from t_book")
    List<Book> getUser();
}
