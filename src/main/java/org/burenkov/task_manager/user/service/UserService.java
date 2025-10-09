package org.burenkov.task_manager.user.service;

import lombok.RequiredArgsConstructor;
import org.burenkov.task_manager.exception.EmailAlreadyExistException;
import org.burenkov.task_manager.user.dto.UserRequest;
import org.burenkov.task_manager.user.dto.UserResponse;
import org.burenkov.task_manager.user.mapper.UserMapper;
import org.burenkov.task_manager.user.model.User;
import org.burenkov.task_manager.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserResponse createUser(UserRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
             throw new EmailAlreadyExistException("Email already exists.");
        }
        User user = userMapper.toEntity(request);
        user.setCreatedAt(LocalDateTime.now());
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserResponse getUserById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.map(userMapper::toDto).orElse(null);
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDto(users);
    }

    public UserResponse updateUser(Long id, UserRequest request) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        User user = optional.get();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
