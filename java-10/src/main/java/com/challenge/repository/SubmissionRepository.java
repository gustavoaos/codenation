package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {

    Optional<Submission> findTopByIdChallengeIdOrderByScoreDesc(Long challengeId);

    List<Submission> findByIdChallengeId(Long challengeId);

}