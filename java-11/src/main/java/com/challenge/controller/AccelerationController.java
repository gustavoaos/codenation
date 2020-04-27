package com.challenge.controller;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
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
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationService service;

    @GetMapping("/{id}")
    public ResponseEntity<Acceleration> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Acceleration>(this.service.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource: acceleration ${id} not found")),
            HttpStatus.OK);
    }

    @GetMapping
    public List<Acceleration> findAll(@PathParam("companyId") Long companyId) {
        return this.service.findByCompanyId(companyId);
    }

}