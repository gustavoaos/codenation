package com.github.gustavoaos.logviewer.service;

import com.github.gustavoaos.logviewer.model.User;
import com.github.gustavoaos.logviewer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository repository;

    @Override
    public User save(User user) {
        return this.repository.save(user) ;
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.repository.findById(id);
    }
    
}