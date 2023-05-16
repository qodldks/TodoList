package com.example.TodoList.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TodoEntity {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column(nullable = false) //not null
    private Boolean completed;

    @Builder
    public TodoEntity(String content, Boolean completed) {
        this.content = content;
        this.completed = completed;
    }
}
