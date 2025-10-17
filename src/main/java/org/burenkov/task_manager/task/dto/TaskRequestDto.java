package org.burenkov.task_manager.task.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class TaskRequestDto {

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String status;

    @NotNull
    private Instant dueDate;
}
