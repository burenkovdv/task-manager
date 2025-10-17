package org.burenkov.task_manager.task.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.burenkov.task_manager.task.dto.TaskRequestDto;
import org.burenkov.task_manager.task.dto.TaskResponseDto;
import org.burenkov.task_manager.task.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping(value = "/api/tasks")
    public ResponseEntity<TaskResponseDto> createTask(@Valid @RequestBody TaskRequestDto request) {
        return ResponseEntity.status(CREATED).body(taskService.create(request));
    }

    @GetMapping(value = "/api/tasks")
    public List<TaskResponseDto> getAll() {
        return  taskService.getAllTasks();
    }

    @PutMapping(value = "/api/tasks/{id}")
    public TaskResponseDto updateTask (@PathVariable Long id, @RequestBody TaskRequestDto request) {
        return taskService.updateTask(id,request);
    }

}
