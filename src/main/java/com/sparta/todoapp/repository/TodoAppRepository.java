package com.sparta.todoapp.repository;

import com.sparta.todoapp.entity.TodoApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TodoAppRepository extends JpaRepository<TodoApp, Long> {
    List<TodoApp> findAllByOrderByDateAsc();
    List<TodoApp> findAllByDate(LocalDateTime createdAt);
}
