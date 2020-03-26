package com.projects.userauthentication.api;

import java.io.Serializable;

public class UserAuthResponse implements Serializable {
    private final Long user;

    public UserAuthResponse(Long user) {
        this.user = user;
    }

    public Long getUser() {
        return this.user;
    }
}
