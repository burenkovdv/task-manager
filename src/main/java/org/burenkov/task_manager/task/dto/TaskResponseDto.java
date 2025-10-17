package org.burenkov.task_manager.task.dto;

import java.sql.Timestamp;

public class TaskResponseDto {
    private Long id;

    private String title;

    private String description;

    private String status;
    private Timestamp createdAt;

    private Timestamp dueDate;
}
