package com.example.TodoList.service;
import lombok.*;

import com.example.TodoList.controller.dto.TodoRequestDto;
import com.example.TodoList.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public Long save(TodoRequestDto requestDto) {
        return todoRepository.save(requestDto.toEntity()).getId();
    }
}
