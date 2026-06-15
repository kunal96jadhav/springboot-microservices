package com.lcwd.user.controller;

import com.lcwd.user.entity.User;
import com.lcwd.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

        User savedUser = userService.saveUser(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {

        User user = userService.getUser(userId);

        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }
}