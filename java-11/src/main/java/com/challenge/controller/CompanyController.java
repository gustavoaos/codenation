package com.challenge.controller;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
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
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Company>(
                this.service.findById(id).orElseThrow(() -> new RuntimeException("Resource: company ${id} not found")),
                HttpStatus.OK);
    }

    @GetMapping
    public List<Company> findAll(@PathParam("accelerationId") Long accelerationId, @PathParam("userId") Long userId) {
        return accelerationId != null ? this.service.findByAccelerationId(accelerationId)
            : this.service.findByUserId(userId);
    }

}