package com.github.gustavoaos.logviewer.repository;

import com.github.gustavoaos.logviewer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}