package org.burenkov.task_manager.task.service;

import lombok.RequiredArgsConstructor;
import org.burenkov.task_manager.task.dto.TaskCreateDto;
import org.burenkov.task_manager.task.dto.TaskResponseDto;
import org.burenkov.task_manager.task.mapper.TaskMapper;
import org.burenkov.task_manager.task.model.Task;
import org.burenkov.task_manager.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;


    public TaskResponseDto create(TaskCreateDto request) {
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

}
