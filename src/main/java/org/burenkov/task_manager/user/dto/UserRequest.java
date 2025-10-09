package org.burenkov.task_manager.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
public class UserRequest {
    private Long id;
    private String email;
    private String password;
    private String name;
}
