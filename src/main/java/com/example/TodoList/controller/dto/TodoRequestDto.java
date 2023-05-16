package com.example.TodoList.controller.dto;

import com.example.TodoList.domain.TodoEntity;
import lombok.*;

@Getter
@NoArgsConstructor
public class TodoRequestDto {
    private String content;
    private Boolean completed;

    public TodoEntity toEntity(){

        return TodoEntity.builder().content(this.content).completed(this.completed).build();
    }
}
