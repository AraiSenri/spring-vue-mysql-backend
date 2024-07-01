package com.example.demo.controller;



import com.example.demo.dto.TodoResponse;
import com.example.demo.mapper.TodoMapper;
import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("")
@RestController
//@CrossOrigin(origins = {"http://localhost:5173"})
public class TodoController {
	

//	@Autowired
//    private final TodoRepository repository;

	
	@Autowired
	private final TodoMapper todoMapper;
	
	public TodoController(TodoMapper todoMapper){
	    this.todoMapper = todoMapper;
	  }

  //  Read
	//@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }
      
	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public TodoResponse findById(@PathVariable int id){
		// DBからidをキーにデータを取得
		Todo item = todoMapper.findById(id);
	
		// Responseにデータをコピーしてreturn
		TodoResponse itemResponse = new TodoResponse();
		//itemResponse.setId(item.getId());
		BeanUtils.copyProperties(item, itemResponse); 
		return itemResponse; 
		
	    }


}

