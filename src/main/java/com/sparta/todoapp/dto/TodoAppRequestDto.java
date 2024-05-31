package com.sparta.todoapp.dto;

import lombok.Getter;

@Getter
public class TodoAppRequestDto {
    private String title;
    private String contents;
    private String manager;
    private Long password;
}
