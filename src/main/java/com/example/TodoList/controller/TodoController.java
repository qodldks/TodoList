package com.example.TodoList.controller;
import com.example.TodoList.controller.dto.TodoRequestDto;
import lombok.*;

import com.example.TodoList.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todo/api")
    public Long create(@RequestBody TodoRequestDto requestDto){
        return todoService.save(requestDto);
    }
}
