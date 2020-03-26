package com.projects.userauthentication.storage;

import com.projects.userauthentication.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

    @Query("select u from UserAuth u where u.userName = ?1")
    Optional<UserAuth> findByUsername(String username);
}
