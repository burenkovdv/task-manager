package org.burenkov.task_manager.task.mapper;

import org.burenkov.task_manager.task.dto.TaskRequestDto;
import org.burenkov.task_manager.task.dto.TaskResponseDto;
import org.burenkov.task_manager.task.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

@Mapper(componentModel = "spring", nullValueCheckStrategy = ALWAYS)
public interface TaskMapper {
    Task toEntity (TaskRequestDto taskRequestDto);
    TaskResponseDto toDto (Task task);
    List<TaskResponseDto> toDto (List<Task> tasks);
}
