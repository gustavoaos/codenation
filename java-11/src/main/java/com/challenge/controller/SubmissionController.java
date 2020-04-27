package com.challenge.controller;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    SubmissionService service;

    @Autowired
    SubmissionMapper mapper;

    @GetMapping
    public List<SubmissionDTO> findByChallengeIdAndAccelerationId(@PathParam("challengeId") Long challengeId,
            @PathParam("accelerationId") Long accelerationId) {
        return this.mapper.map(this.service.findByChallengeIdAndAccelerationId(challengeId, accelerationId));
    }

}