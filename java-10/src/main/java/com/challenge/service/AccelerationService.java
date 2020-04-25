package com.challenge.service;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("accelerationService")
public class AccelerationService implements AccelerationServiceInterface {

    @Autowired
    private AccelerationRepository repository;

    @Override
    public Acceleration save(Acceleration acceleration) {
        return this.repository.save(acceleration);
    }

    @Override
    public Optional<Acceleration> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Optional<Acceleration> findByName(String name) {
        return this.repository.findByName(name);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return this.repository.findByCandidatesIdCompanyId(companyId);
    }

}