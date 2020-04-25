package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    List<Company> findDistinctCompanyByCandidatesIdAccelerationId(Long accelerationId);

    List<Company> findByCandidatesIdUserId(Long userId);

}