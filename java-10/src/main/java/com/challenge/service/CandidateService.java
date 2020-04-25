package com.challenge.service;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("candidateService")
public class CandidateService implements CandidateServiceInterface {

    @Autowired
    private CandidateRepository repository;

    @Override
    public Candidate save(Candidate candidate) {
        return this.repository.save(candidate);
    }

    @Override
    public Optional<Candidate> findById(CandidateId id) {
        return this.repository.findById(id);
    }

    @Override
    public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
        return this.repository.findByIdUserIdAndIdCompanyIdAndIdAccelerationId(userId, companyId, accelerationId);
    }

    @Override
    public List<Candidate> findByCompanyId(Long companyId) {
        return this.repository.findByIdCompanyId(companyId);
    }

    @Override
    public List<Candidate> findByAccelerationId(Long accelerationId) {
        return this.repository.findByIdAccelerationId(accelerationId);
    }

}