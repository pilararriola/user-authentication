package com.projects.userauthentication.controller;

import com.projects.userauthentication.api.UserResponse;
import com.projects.userauthentication.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:3001" })
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public UserResponse user(@PathVariable("id") Long userId) {
        return userService.user(userId);
    }
}
