package com.challenge.service;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Submission;
import com.challenge.repository.AccelerationRepository;
import com.challenge.repository.ChallengeRepository;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("submissionService")
class SubmissionService implements SubmissionServiceInterface {

    @Autowired
    private SubmissionRepository repository;

    @Autowired
    private AccelerationRepository accelerationRepository;

    @Override
    public Submission save(Submission submission) {
        return this.repository.save(submission);
    }

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        Optional<Submission> submission = this.repository.findTopByIdChallengeIdOrderByScoreDesc(challengeId);
        BigDecimal higherScore = submission.isPresent() ? BigDecimal.valueOf(submission.get().getScore()) : BigDecimal.ZERO;

        return higherScore;
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return this.accelerationRepository.findById(accelerationId).get().getChallenge().getSubmissions().stream()
            .filter(submission -> submission.getId().getChallenge().getId().equals(challengeId))
            .collect(Collectors.toList());
    }

}