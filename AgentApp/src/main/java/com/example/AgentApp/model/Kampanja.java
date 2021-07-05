package com.example.AgentApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Kampanja {

    @Id
    @SequenceGenerator(name = "seq_kampanja", sequenceName = "seq_kampanja", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_kampanja")
    private Integer id;


    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Agent agent;

    @OneToMany(mappedBy = "kampanja", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Izvestaj> izvestaj = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Set<Izvestaj> getIzvestaj() {
        return izvestaj;
    }

    public void setIzvestaj(Set<Izvestaj> izvestaj) {
        this.izvestaj = izvestaj;
    }

    public Kampanja() {
    }

    public Kampanja(Integer id, Agent agent, Set<Izvestaj> izvestaj) {
        this.id = id;
        this.agent = agent;
        this.izvestaj = izvestaj;
    }
}
