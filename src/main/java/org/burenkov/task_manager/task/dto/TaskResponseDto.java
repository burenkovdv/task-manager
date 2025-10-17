package org.burenkov.task_manager.task.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private String status;
    private Instant createdAt;
    private Instant dueDate;
}
