package org.burenkov.task_manager.task.controller;

import lombok.RequiredArgsConstructor;
import org.burenkov.task_manager.task.dto.TaskCreateDto;
import org.burenkov.task_manager.task.dto.TaskResponseDto;
import org.burenkov.task_manager.task.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping(value = "/api/tasks")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskCreateDto request) {
        return ResponseEntity.status(CREATED).body(taskService.create(request));
    }

    @GetMapping(value = "/api/tasks")
    public List<TaskResponseDto> getAll() {
        return  taskService.getAllTasks();
    }

}
