package org.burenkov.task_manager.task.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name="tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String status;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "due_date")
    private Instant dueDate;

}
