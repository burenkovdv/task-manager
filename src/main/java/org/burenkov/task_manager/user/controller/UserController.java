package org.burenkov.task_manager.user.controller;

import lombok.RequiredArgsConstructor;
import org.burenkov.task_manager.exception.EmailAlreadyExistException;
import org.burenkov.task_manager.user.dto.UserRequest;
import org.burenkov.task_manager.user.dto.UserResponse;
import org.burenkov.task_manager.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser (@RequestBody UserRequest request) {
        try {
            return ResponseEntity.ok(userService.createUser(request));
        } catch (EmailAlreadyExistException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        UserResponse response = userService.getUserById(id);
        if (response == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<UserResponse> getUsers () {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUsers(@PathVariable Long id, @RequestBody UserRequest request){
        UserResponse response = userService.updateUser(id, request);
        if (response == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
