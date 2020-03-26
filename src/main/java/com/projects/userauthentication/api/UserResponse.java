package com.projects.userauthentication.api;

import java.io.Serializable;
import java.time.LocalDate;

public class UserResponse implements Serializable {

    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String emailAddress;

    public UserResponse() {
    }

    public UserResponse(String firstName, String lastName, LocalDate birthday, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
