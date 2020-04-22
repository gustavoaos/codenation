package com.challenge.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Data
@Embeddable
public class CandidatePK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "acceleration_id", nullable = false)
    private Acceleration acceleration;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

}