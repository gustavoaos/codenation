package com.github.gustavoaos.logviewer.controller;

import com.github.gustavoaos.logviewer.model.User;
import com.github.gustavoaos.logviewer.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/user")
@Api(tags = { "User" }, description = "Not so much about your Users")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Creates a new User")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "successful operation")
    })
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        return new ResponseEntity<User>(
            this.service.save(user),
            HttpStatus.CREATED);
    }
    
}