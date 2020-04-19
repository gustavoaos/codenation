package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Player {

    private Long id;
    private Long teamId;
    private String name;
    private LocalDate birthdate;
    private Integer abilityLevel;
    private BigDecimal salary;
    private Boolean isCaptain;

    public Player(Long id, Long teamId, String name, LocalDate birthdate, Integer abilityLevel, BigDecimal salary) {
        this.id = id;
        this.teamId = teamId;
        this.name = name;
        this.birthdate = birthdate;
        this.abilityLevel = abilityLevel;
        this.salary = salary;
        this.isCaptain = false;
    }

    public Long getId() {
        return this.id;
    }

    public Long getTeamId() {
        return this.teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    public Integer getAbilityLevel() {
        return this.abilityLevel;
    }

    public void setAbilityLevel(Integer abilityLevel) {
        this.abilityLevel = abilityLevel;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Boolean getIsCaptain() {
        return this.isCaptain;
    }

    public void setIsCaptain(Boolean isCaptain) {
        this.isCaptain = isCaptain;
    }

}