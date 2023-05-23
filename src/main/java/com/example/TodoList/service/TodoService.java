package com.example.TodoList.service;
import com.example.TodoList.controller.dto.TodoResponseDto;
import com.example.TodoList.domain.TodoEntity;
import lombok.*;

import com.example.TodoList.controller.dto.TodoRequestDto;
import com.example.TodoList.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public Long save(TodoRequestDto requestDto) {
        return todoRepository.save(requestDto.toEntity()).getId();
    }

    public List<TodoResponseDto> findAll() {
        List<TodoEntity> result = todoRepository.findAll();
        List<TodoResponseDto> responseDtos = new ArrayList<>();
        //변환 작업

        for (TodoEntity todoEntity : result) {
            responseDtos.add(new TodoResponseDto(todoEntity));
        }

        return responseDtos;
    }

    public TodoResponseDto findOne(Long id) {
        TodoEntity todoEntity = todoRepository.findById(id).orElse(new TodoEntity());
        return new TodoResponseDto(todoEntity);
    }

    @Transactional
    public Long updateById(Long id, TodoRequestDto requestDto) {
        //id 값을 통해 DB 접속
        TodoEntity todoEntity = todoRepository.findById(id).orElse(new TodoEntity());
        //수정
        todoEntity.updateContent(requestDto.getContent());
        todoEntity.updateCompleted(requestDto.getCompleted());

        return todoEntity.getId();
    }

    public void deleteAll() {
        todoRepository.deleteAll();
    }

    public void deleteOne(Long id) {
        todoRepository.deleteById(id);
    }
}
