package com.example.demo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Todo;

@Mapper
public interface TodoMapper {
    Todo findById(int id);
    
}