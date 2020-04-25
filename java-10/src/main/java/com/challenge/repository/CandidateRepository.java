package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {

    List<Candidate> findByIdAccelerationName(String accelerationName);

    List<Candidate> findByIdCompanyId(Long companyId);

    Optional<Candidate> findByIdUserIdAndIdCompanyIdAndIdAccelerationId(Long userId, Long companyId, Long accelerationId);

    List<Candidate> findByIdAccelerationId(Long accelerationId);

    List<Candidate> findByIdAccelerationIdAndIdUserId(Long accelerationId, Long userId);
}