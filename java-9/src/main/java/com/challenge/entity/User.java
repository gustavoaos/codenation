package com.challenge.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "full_name", length = 100)
    private String fullName;

    @Email
    @NotNull
    @Size(min = 1, max = 100)
    @Column(length = 100)
    private String email;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(length = 50)
    private String nickname;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(length = 255)
    private String password;

    @NotNull
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @OneToMany(mappedBy = "primaryKey.user")
    private List<Candidate> candidates;

    @OneToMany(mappedBy = "primaryKey.user")
    private List<Submission> submissions;

}