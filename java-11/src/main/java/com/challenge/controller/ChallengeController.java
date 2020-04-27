package com.challenge.controller;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeService service;

    @GetMapping
    public List<Challenge> findByAccelerationIdAndUserId(@PathParam("accelerationId") Long accelerationId,
            @PathParam("userId") Long userId) {
        return this.service.findByAccelerationIdAndUserId(accelerationId, userId);
    }

}