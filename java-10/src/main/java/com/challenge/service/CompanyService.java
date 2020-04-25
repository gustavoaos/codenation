package com.challenge.service;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("companyService")
public class CompanyService implements CompanyServiceInterface {

    @Autowired
    private CompanyRepository repository;

    @Override
    public Company save(Company company) {
        return this.repository.save(company);
    }

    @Override
    public Optional<Company> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        return this.repository.findDistinctCompanyByCandidatesIdAccelerationId(accelerationId);
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        return this.repository.findByCandidatesIdUserId(userId);
    }

}