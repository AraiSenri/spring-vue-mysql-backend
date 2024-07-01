package com.example.demo.dto;


import lombok.Data;
import lombok.Setter;

@Setter
@Data
public class TodoResponse {
    private long id;
    private String content;
}
