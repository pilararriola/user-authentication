package com.projects.userauthentication.controller;

import com.projects.userauthentication.errorHandler.BadRequestException;
import com.projects.userauthentication.api.UserAuthRequest;
import com.projects.userauthentication.api.UserAuthResponse;
import com.projects.userauthentication.service.UserAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:3001" })
public class UserAuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAuthController.class);
    private UserAuthService userAuthService;

    public  UserAuthController(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    @PostMapping("/authenticate")
    public UserAuthResponse authenticate(@RequestBody UserAuthRequest authenticationRequest) {
        try {
            String username = Objects.requireNonNull(authenticationRequest.getUsername());
            String password = Objects.requireNonNull(authenticationRequest.getPassword());
            LOGGER.info("New request from user {}", username);

            return userAuthService.authenticate(username, password);
        } catch (NullPointerException e) {
            throw new BadRequestException("username and password must not be null");
        }
    }
}
