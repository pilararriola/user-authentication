package com.projects.userauthentication.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="USER_AUTH")
public class UserAuth {

    @Id
    @GeneratedValue
    @Column(name="ID_USER_AUTH")
    private Long idUserAuth;

    @Column(name="USER_NAME", nullable = false, unique = true)
    private String userName;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="SALT")
    private String salt;

    @Column(name="LAST_ACCESS")
    private LocalDateTime lastAccess;

    @OneToOne
    @JoinColumn(name = "ID_USER_INFORMATION")
    private User user;

    public UserAuth() {
    }

    public Long getIdUserAuth() {
        return idUserAuth;
    }

    public void setIdUserAuth(Long idUserAuth) {
        this.idUserAuth = idUserAuth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public LocalDateTime getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(LocalDateTime lastAccess) {
        this.lastAccess = lastAccess;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
