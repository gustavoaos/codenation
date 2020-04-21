package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "submission")
public class Submission implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // @EmbeddedId
    // @PrimaryKeyJoinColumns({
    //     @PrimaryKeyJoinColumn(name = "user", referencedColumnName = "user_id"),
    //     @PrimaryKeyJoinColumn(name = "challenge", referencedColumnName = "challenge_id")
    // })
    @EmbeddedId
    private SubmissionPK primaryKey;

    @NotNull
    private double score;
    
    @NotNull
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

}