package com.github.gustavoaos.logviewer.service;

import com.github.gustavoaos.logviewer.model.User;

import java.util.Optional;

public interface UserServiceInterface {

    User save(User user);

    Optional<User> findById(Long id);
    
}