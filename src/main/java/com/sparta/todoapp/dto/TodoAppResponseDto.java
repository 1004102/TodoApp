package com.sparta.todoapp.dto;

import com.sparta.todoapp.entity.TodoApp;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoAppResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String manager;
    private LocalDateTime createdAt;

    public  TodoAppResponseDto(TodoApp todoApp){
        this.id = todoApp.getId();
        this.title = todoApp.getTitle();
        this.contents = todoApp.getContents();
        this.manager = todoApp.getManager();
        this.createdAt = todoApp.getCreatedAt();
    }
}
