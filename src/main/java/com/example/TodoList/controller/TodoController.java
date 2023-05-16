package com.example.TodoList.controller;
import com.example.TodoList.controller.dto.TodoRequestDto;
import com.example.TodoList.controller.dto.TodoResponseDto;
import lombok.*;

import com.example.TodoList.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todo/api")
    public Long create(@RequestBody TodoRequestDto requestDto){
        return todoService.save(requestDto);
    }

    @GetMapping("/todo/api")
    public List<TodoResponseDto> readAll(){
        return todoService.findAll();
    }

    //id를 통해 엔티티 하나 들고오기
    @GetMapping("/todo/api/{id}")
    public TodoResponseDto readOne(@PathVariable Long id){
        return todoService.findOne(id);
    }

    @PutMapping("/todo/api/{id}")
    public Long update(@RequestBody TodoRequestDto requestDto, @PathVariable Long id){
        return todoService.updateById(id, requestDto);
    }
}
