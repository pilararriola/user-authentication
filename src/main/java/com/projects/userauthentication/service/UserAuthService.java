package com.projects.userauthentication.service;

import com.projects.userauthentication.api.UserAuthResponse;
import com.projects.userauthentication.errorHandler.UsernameNotFoundException;
import com.projects.userauthentication.errorHandler.WrongPasswordException;
import com.projects.userauthentication.model.UserAuth;
import com.projects.userauthentication.storage.UserAuthRepository;
import com.projects.userauthentication.utils.PasswordUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserAuthService {

    private UserAuthRepository userAuthRepository;

    public UserAuthService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    public UserAuthResponse authenticate(String username, String password) {
        UserAuth userAuth = userAuthRepository.findByUsername(username)
                .orElseThrow(UsernameNotFoundException::new);

        if(!PasswordUtils.verifyUserPassword(password,userAuth.getPassword(),userAuth.getSalt())) {
            throw new WrongPasswordException();
        }

        userAuth.setLastAccess(LocalDateTime.now());
        userAuthRepository.save(userAuth);

        return new UserAuthResponse(userAuth.getUser().getIdUser());
    }
}
