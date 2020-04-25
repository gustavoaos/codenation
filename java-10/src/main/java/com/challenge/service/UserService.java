package com.challenge.service;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import com.challenge.entity.Submission;
import com.challenge.entity.User;
import com.challenge.repository.CandidateRepository;
import com.challenge.repository.SubmissionRepository;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("userService")
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository repository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private SubmissionRepository submissionRepository;

    @Override
    public User save(User user) {
        this.fillCandidates(user);
        this.fillSubmissions(user);

        user.setCreatedAt(LocalDateTime.now());
        return repository.save(user);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return this.repository.findById(userId);
    }

    @Override
    public List<User> findByAccelerationName(String accelerationName) {
        return this.candidateRepository.findByIdAccelerationName(accelerationName).stream()
            .map(candidate -> candidate.getId().getUser())
            .collect(Collectors.toList());
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        return this.candidateRepository.findByIdCompanyId(companyId).stream()
            .map(candidate -> candidate.getId().getUser())
            .collect(Collectors.toList());
    }

    private void fillCandidates(User user) {
        if (user.getCandidates() != null) {
            List<Candidate> persistedCandidates = new ArrayList<>();

            for (Candidate candidate : user.getCandidates()) {
                Optional<Candidate> optional = this.candidateRepository.findById(candidate.getId());
                
                if (optional.isPresent()) {
                    persistedCandidates.add(optional.get());
                } else {
                    persistedCandidates.add(this.candidateRepository.save(candidate));
                }
            }

            user.setCandidates(persistedCandidates);
        }
    }

    private void fillSubmissions(User user) {
        if (user.getSubmissions() != null) {
            List<Submission> persistedSubmissions = new ArrayList<>();

            for (Submission submission : user.getSubmissions()) {
                Optional<Submission> optional = this.submissionRepository.findById(submission.getId());
                
                if (optional.isPresent()) {
                    persistedSubmissions.add(optional.get());
                } else {
                    persistedSubmissions.add(this.submissionRepository.save(submission));
                }
            }

            user.setSubmissions(persistedSubmissions);
        }
    }

}