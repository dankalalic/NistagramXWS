package com.example.AgentApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Proizvod {
    @Id
    @SequenceGenerator(name = "seq_proizvod", sequenceName = "seq_proizvod", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_proizvod")
    private Integer id;

    @Column
    private Integer cena;
    @Column
    private Integer raspolozivoStanje;
    @Column
    private Integer slika;

    @Column
    private Integer kolicinazaporudzbinu;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Agent agent;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Prodavnica prodavnica;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Korpa korpa;

    @ManyToMany(mappedBy = "proizvod")
    private Set<Narudzbina> narudzbina = new HashSet<Narudzbina>();

    public Integer getKolicinazaporudzbinu() {
        return kolicinazaporudzbinu;
    }

    public void setKolicinazaporudzbinu(Integer kolicinazaporudzbinu) {
        this.kolicinazaporudzbinu = kolicinazaporudzbinu;
    }

    public Proizvod(Integer cena, Integer slika) {
    }

    public Proizvod(Integer cena, Integer raspolozivoStanje, Integer slika) {
    }


    public Integer getRaspolozivoStanje() {
        return raspolozivoStanje;
    }

    public void setRaspolozivoStanje(Integer raspolozivoStanje) {
        this.raspolozivoStanje = raspolozivoStanje;
    }

    public Integer getSlika() {
        return slika;
    }

    public void setSlika(Integer slika) {
        this.slika = slika;
    }

    public Proizvod() {
    }

    public Proizvod(Integer id, Integer cena, Integer slika, Agent agent, Set<Narudzbina> narudzbina) {
        this.id = id;
        this.cena = cena;
        this.slika = slika;
        this.agent = agent;
        this.narudzbina = narudzbina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }


    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Set<Narudzbina> getNarudzbina() {
        return narudzbina;
    }

    public void setNarudzbina(Set<Narudzbina> narudzbina) {
        this.narudzbina = narudzbina;
    }
}
