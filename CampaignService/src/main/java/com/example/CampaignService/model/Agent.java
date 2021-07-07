package com.example.CampaignService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Agent {

    @Id
    private Integer id;

    @JsonIgnore
    @OneToMany(mappedBy = "agent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Kampanja> kampanje = new HashSet<>();

    public Agent(Integer id) {
        this.id = id;
    }

    public Agent() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Kampanja> getKampanje() {
        return kampanje;
    }

    public void setKampanje(Set<Kampanja> kampanje) {
        this.kampanje = kampanje;
    }
}
