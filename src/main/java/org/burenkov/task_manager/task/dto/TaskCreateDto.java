package org.burenkov.task_manager.task.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class TaskCreateDto {

    private String title;
    private String description;
    private String status;
    private Timestamp dueDate;
}
