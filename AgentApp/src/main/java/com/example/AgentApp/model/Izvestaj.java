package com.example.AgentApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Izvestaj {
    @Id
    @SequenceGenerator(name = "seq_izvestaj", sequenceName = "seq_izvestaj", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_izvestaj")
    private Integer id;


    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Kampanja kampanja;

    public Izvestaj(Integer id, Kampanja kampanja) {
        this.id = id;
        this.kampanja = kampanja;
    }

    public Izvestaj() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Kampanja getKampanja() {
        return kampanja;
    }

    public void setKampanja(Kampanja kampanja) {
        this.kampanja = kampanja;
    }
}

