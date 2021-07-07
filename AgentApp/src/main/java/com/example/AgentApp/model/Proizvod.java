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
    private String  naziv;

    @Lob
    @OneToOne(mappedBy = "proizvod", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Slika slika;

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

    @JsonIgnore
    @ManyToMany(mappedBy = "proizvod")
    private Set<Narudzbina> narudzbina = new HashSet<Narudzbina>();

    public Prodavnica getProdavnica() {
        return prodavnica;
    }

    public Proizvod(Integer id, Integer cena, Integer raspolozivoStanje, String naziv, Slika slika, Integer kolicinazaporudzbinu, Agent agent, Prodavnica prodavnica, Korpa korpa, Set<Narudzbina> narudzbina) {
        this.id = id;
        this.cena = cena;
        this.raspolozivoStanje = raspolozivoStanje;
        this.naziv = naziv;
        this.slika = slika;
        this.kolicinazaporudzbinu = kolicinazaporudzbinu;
        this.agent = agent;
        this.prodavnica = prodavnica;
        this.korpa = korpa;
        this.narudzbina = narudzbina;
    }

    public void setProdavnica(Prodavnica prodavnica) {
        this.prodavnica = prodavnica;
    }

    public Korpa getKorpa() {
        return korpa;
    }

    public void setKorpa(Korpa korpa) {
        this.korpa = korpa;
    }

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

    public Slika getSlika() {
        return slika;
    }

    public void setSlika(Slika slika) {
        this.slika = slika;
    }

    public Proizvod() {
    }

    public Proizvod(Integer id, Integer cena, Agent agent, Set<Narudzbina> narudzbina) {
        this.id = id;
        this.cena = cena;
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

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
