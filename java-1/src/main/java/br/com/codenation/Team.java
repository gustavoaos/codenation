package br.com.codenation;

import java.time.LocalDate;

/**
 * Team
 */
public class Team {

    private Long id;
    private String name;
    private LocalDate creationDate;
    private String mainUniformColor;
    private String secondaryUniformColor;

    public Team(Long id, String name, LocalDate creationDate, String mainUniformColor, String secondaryUniformColor) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.mainUniformColor = mainUniformColor;
        this.secondaryUniformColor = secondaryUniformColor;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getMainUniformColor() {
        return this.mainUniformColor;
    }

    public void setMainUniformColor(String mainUniformColor) {
        this.mainUniformColor = mainUniformColor;
    }

    public String getSecondaryUniformColor() {
        return this.secondaryUniformColor;
    }

    public void setSecondaryUniformColor(String secondaryUniformColor) {
        this.secondaryUniformColor = secondaryUniformColor;
    }
    
}