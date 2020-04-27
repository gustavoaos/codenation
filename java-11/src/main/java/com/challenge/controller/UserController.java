package com.challenge.controller;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<User>(
                this.service.findById(id).orElseThrow(() -> new RuntimeException("Resource: livro ${id} not found")),
                HttpStatus.OK);
    }

    @GetMapping
    public List<User> findAll(@PathParam("accelerationName") String accelerationName,
            @PathParam("companyId") Long companyId) {

        return accelerationName != null ? this.service.findByAccelerationName(accelerationName)
                : this.service.findByCompanyId(companyId);
    }

}