package com.projects.userauthentication.errorHandler;

public class UsernameNotFoundException extends AuthenticationException {

     public UsernameNotFoundException() {
         super("INVALID_USERNAME");
     }
}
