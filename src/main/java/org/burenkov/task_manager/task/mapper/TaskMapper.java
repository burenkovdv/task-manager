package org.burenkov.task_manager.task.mapper;

import org.burenkov.task_manager.task.dto.TaskCreateDto;
import org.burenkov.task_manager.task.dto.TaskResponseDto;
import org.burenkov.task_manager.task.model.Task;

import java.util.List;

public interface TaskMapper {
    Task toEntity (TaskCreateDto taskCreateDto);
    TaskResponseDto toDto (Task tasks);
    List<TaskResponseDto> toDto (List<Task> tasks);
}
