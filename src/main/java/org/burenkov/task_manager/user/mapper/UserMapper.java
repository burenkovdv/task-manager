package org.burenkov.task_manager.user.mapper;

import org.burenkov.task_manager.user.dto.UserRequest;
import org.burenkov.task_manager.user.dto.UserResponse;
import org.burenkov.task_manager.user.model.User;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

@Mapper(componentModel = "spring", nullValueCheckStrategy = ALWAYS)
public interface UserMapper {

    User toEntity(UserRequest userRequest);

    UserResponse toDto(User user);

    List<UserResponse> toDto(List<User> users);
}
