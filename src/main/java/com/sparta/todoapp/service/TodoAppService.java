package com.sparta.todoapp.service;

import com.sparta.todoapp.dto.TodoAppRequestDto;
import com.sparta.todoapp.dto.TodoAppResponseDto;
import com.sparta.todoapp.entity.TodoApp;
import com.sparta.todoapp.repository.TodoAppRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoAppService {

    private final TodoAppRepository todoAppRepository;

    public TodoAppService(TodoAppRepository todoAppRepository) {
        this.todoAppRepository = todoAppRepository;
    }

    public TodoAppResponseDto createTodoApp(TodoAppRequestDto todoAppRequestDto) {
        // RequestDto -> Entity
        TodoApp todoApp = new TodoApp(todoAppRequestDto);

        // DB 저장
        TodoApp saveTodoApp = todoAppRepository.save(todoApp);

        // Entity -> ResponseDto
        TodoAppResponseDto todoAppResponseDto = new TodoAppResponseDto(saveTodoApp);

        return todoAppResponseDto;
    }

    public List<TodoAppResponseDto> getTodoApps() {
        return todoAppRepository.findAllByOrderByDateAsc().stream()
                .map(TodoAppResponseDto::new).toList();
    }

    public List<TodoAppResponseDto> getDateTodoApps(LocalDateTime createdAt) {
        return  todoAppRepository.findAllByDate(createdAt).stream().map(TodoAppResponseDto::new).toList();
    }

    @Transactional
    public Long updateTodoApp(Long id, TodoAppRequestDto todoAppRequestDto) {
        // 해당 내용 DB에 존재하는지 확인
        TodoApp todoApp = findTodoApp(id);
        // 해당 내용 수정
        todoApp.update(todoAppRequestDto);

        return id;
    }
    public Long deleteTodoApp(Long id, TodoAppRequestDto todoAppRequestDto) {
        TodoApp todoApp = findTodoApp(id);

        // 해당 내용 삭제
        todoAppRepository.delete(todoApp);

        return id;
    }

    private TodoApp findTodoApp(Long id) {
        return todoAppRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 일정은 존재하지 않습니다.")
        );
    }

}
