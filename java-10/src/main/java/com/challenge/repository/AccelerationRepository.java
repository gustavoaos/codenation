package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

    Optional<Acceleration> findByName(String name);

    List<Acceleration> findByCandidatesIdCompanyId(Long companyId);

}