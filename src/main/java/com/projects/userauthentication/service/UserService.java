package com.projects.userauthentication.service;

import com.projects.userauthentication.api.UserResponse;
import com.projects.userauthentication.errorHandler.BadRequestException;
import com.projects.userauthentication.model.User;
import com.projects.userauthentication.storage.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse user(Long userId) {
        return userRepository.findById(userId).map(this::mapUserToUserResponse)
                .orElseThrow(() -> new BadRequestException(
                        String.format("User was not found. Invalid id: %s", userId)));
    }

    private UserResponse mapUserToUserResponse(User user) {
        return new UserResponse(user.getFirstName(),
                user.getLastName(), user.getBirthday(), user.getEmailAddress());
    }
}
