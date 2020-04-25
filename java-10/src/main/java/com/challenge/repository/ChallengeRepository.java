package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

}