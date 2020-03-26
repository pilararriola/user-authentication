package com.projects.userauthentication.errorHandler;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiException {

    private static int CODE = HttpStatus.valueOf("BAD_REQUEST").value();

    public BadRequestException() {
        super(CODE);
    }

    public BadRequestException(String message) {
        super(CODE, message);
    }
}
