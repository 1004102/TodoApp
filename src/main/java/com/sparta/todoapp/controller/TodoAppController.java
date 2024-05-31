package com.sparta.todoapp.controller;

import com.sparta.todoapp.dto.TodoAppRequestDto;
import com.sparta.todoapp.dto.TodoAppResponseDto;
import com.sparta.todoapp.service.TodoAppService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/todoapp")
public class TodoAppController {

    private final TodoAppService todoAppService;

    public TodoAppController(TodoAppService todoAppService) {
        this.todoAppService = todoAppService;
    }


    @PostMapping
    public TodoAppResponseDto createTodoApp(@RequestBody TodoAppRequestDto todoAppRequestDto) {
        return todoAppService.createTodoApp(todoAppRequestDto);
    }

    @GetMapping
    public List<TodoAppResponseDto> getTodoApps() {
        return todoAppService.getTodoApps();
    }

    @GetMapping("/search")
    private List<TodoAppResponseDto> getTodoAppsByDate(@RequestParam LocalDateTime createdAt) {
        return todoAppService.getDateTodoApps(createdAt);
    }

    @PutMapping("/{id}")
    public Long updateTodoApp(@PathVariable Long id, @RequestBody TodoAppRequestDto todoAppRequestDto) {
        return todoAppService.updateTodoApp(id, todoAppRequestDto);
    }

    @DeleteMapping("/{id}")
    public Long deleteTodoApp(@PathVariable Long id, @RequestBody TodoAppRequestDto todoAppRequestDto) {
        return todoAppService.deleteTodoApp(id, todoAppRequestDto);
    }
}
