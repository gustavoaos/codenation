package com.challenge.service;

import com.challenge.entity.Challenge;
import com.challenge.repository.CandidateRepository;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("challengeService")
public class ChallengeService implements ChallengeServiceInterface {

    @Autowired
    private ChallengeRepository repository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Challenge save(Challenge challenge) {
        return this.repository.save(challenge);
    }

    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return this.candidateRepository.findByIdAccelerationIdAndIdUserId(accelerationId, userId).stream()
            .map(candidate -> candidate.getId().getAcceleration().getChallenge())
            .collect(Collectors.toList());
    }

}