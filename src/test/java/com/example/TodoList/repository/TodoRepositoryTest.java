package com.example.TodoList.repository;

import com.example.TodoList.domain.TodoEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoRepositoryTest {
    @Autowired
    TodoRepository todoRepository;

    @AfterEach
    public void reset(){
        //디비초기화
        todoRepository.deleteAll();
    }

    @Test
    public void saveValues(){
        //1. 엔티티 하나 만들기
        TodoEntity entity = TodoEntity.builder().content("a content").completed(false).build();

        //2. 디비에 저장
        todoRepository.save(entity);

        //3. 확인
        List<TodoEntity> all = todoRepository.findAll();
        assertEquals(all.get(0).getContent(), "a content");

    }
}