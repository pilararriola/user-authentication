package com.projects.userauthentication.errorHandler;

import org.springframework.http.HttpStatus;

public class AuthenticationException extends ApiException {

    private static int CODE = HttpStatus.valueOf("UNAUTHORIZED").value();

    public AuthenticationException() {
        super(CODE);
    }

    public AuthenticationException(String message) {
        super(CODE, message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(CODE, message, cause);
    }
}
