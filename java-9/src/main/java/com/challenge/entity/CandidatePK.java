package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class CandidatePK implements Serializable {

    private static final long serialVersionUID = 1L;

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