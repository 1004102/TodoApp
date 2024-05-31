package com.sparta.todoapp.entity;

import com.sparta.todoapp.dto.TodoAppRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity     // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "todoApp")
@NoArgsConstructor
public class TodoApp extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;
    @Column(name = "manager", nullable = false)
    private String manager;
    @Column(name = "created_At", nullable = false)
    private LocalDateTime createdAt;

    public TodoApp(TodoAppRequestDto todoAppRequestDto) {
        this.title = todoAppRequestDto.getTitle();
        this.contents = todoAppRequestDto.getContents();
        this.manager = todoAppRequestDto.getManager();
        this.createdAt = LocalDateTime.now();
    }

    public void update(TodoAppRequestDto todoAppRequestDto) {
        this.title = todoAppRequestDto.getTitle();
        this.contents = todoAppRequestDto.getContents();
        this.manager = todoAppRequestDto.getManager();
        this.createdAt = LocalDateTime.now();
    }
}
