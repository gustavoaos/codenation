package com.challenge.controller;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService service;

    @Autowired
    CandidateMapper mapper;

    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    public ResponseEntity<CandidateDTO> findById(@PathVariable("userId") Long userId,
            @PathVariable("accelerationId") Long accelerationId,
            @PathVariable("companyId") Long companyId) {

        return new ResponseEntity<CandidateDTO>(
                this.mapper.map(this.service.findById(userId, companyId, accelerationId)
                        .orElseThrow(() -> new RuntimeException("Resource: candidate ${id} not found"))),
                HttpStatus.OK);
    }

    @GetMapping
    public List<Candidate> findAll(@PathParam("accelerationId") Long accelerationId,
            @PathParam("companyId") Long companyId) {

        return accelerationId != null ? this.service.findByAccelerationId(accelerationId)
                : this.service.findByCompanyId(companyId);
    }

}