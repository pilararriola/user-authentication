package com.projects.userauthentication.errorHandler;

public class WrongPasswordException extends AuthenticationException {

     public WrongPasswordException() {
         super("INVALID_PASSWORD");
     }
}
