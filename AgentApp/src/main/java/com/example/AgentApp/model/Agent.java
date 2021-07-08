package com.example.AgentApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("agent")
public class Agent extends User{
    @Id
    private Integer id;

    @OneToMany(mappedBy = "agent", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<Kampanja> kampanje = new HashSet<>();

    @OneToMany(mappedBy = "agent", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<Proizvod> proizvodi = new HashSet<>();

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prodavnica_id", referencedColumnName = "id")
    private Prodavnica prodavnica;

    public Agent(Integer id, Set<Kampanja> kampanje, Set<Proizvod> proizvodi) {
        this.id = id;
        this.kampanje = kampanje;
        this.proizvodi = proizvodi;
    }

    public Agent() {
    }

    public Prodavnica getProdavnica() {
        return prodavnica;
    }

    public void setProdavnica(Prodavnica prodavnica) {
        this.prodavnica = prodavnica;
    }

    public Set<Kampanja> getKampanje() {
        return kampanje;
    }

    public void setKampanje(Set<Kampanja> kampanje) {
        this.kampanje = kampanje;
    }

    public Set<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(Set<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
