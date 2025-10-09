package org.burenkov.task_manager.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    private Long id;
    private String email;
    @JsonIgnore
    private String password;
    private String name;
    private LocalDateTime createdAt;
}
