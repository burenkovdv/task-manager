package org.burenkov.task_manager.task.service;

import lombok.RequiredArgsConstructor;
import org.burenkov.task_manager.task.dto.TaskRequestDto;
import org.burenkov.task_manager.task.dto.TaskResponseDto;
import org.burenkov.task_manager.task.mapper.TaskMapper;
import org.burenkov.task_manager.task.model.Task;
import org.burenkov.task_manager.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;


    public TaskResponseDto create(TaskRequestDto request) {
        Task task = taskMapper.toEntity(request);
        task.setCreatedAt(Instant.now());
        task = taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    public List<TaskResponseDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return taskMapper.toDto(tasks);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public TaskResponseDto updateTask(Long id, TaskRequestDto request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Задача не найдена, id = " + id));
        updateTaskFields(task, request);
        task = taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    private void updateTaskFields(Task task, TaskRequestDto request) {
        Optional.ofNullable(request.getTitle()).ifPresent(task::setTitle);
        Optional.ofNullable(request.getDescription()).ifPresent(task::setDescription);
        Optional.ofNullable(request.getDueDate()).ifPresent(task::setDueDate);
        Optional.ofNullable(request.getStatus()).ifPresent(task::setStatus);

    }

}
