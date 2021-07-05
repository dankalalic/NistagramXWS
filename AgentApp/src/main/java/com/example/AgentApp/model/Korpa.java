package com.example.AgentApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Korpa {


    @Id
    @SequenceGenerator(name = "seq_korpa", sequenceName = "seq_korpa", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_korpa")
    private Integer id;


    @OneToMany(mappedBy = "korpa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Proizvod> proizvodi = new HashSet<>();

    @OneToOne(mappedBy = "korpa")
    private RegistrovaniKorisnik registrovaniKorisnik;

    public RegistrovaniKorisnik getRegistrovaniKorisnik() {
        return registrovaniKorisnik;
    }

    public void setRegistrovaniKorisnik(RegistrovaniKorisnik registrovaniKorisnik) {
        this.registrovaniKorisnik = registrovaniKorisnik;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(Set<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }

    public Korpa() {
    }
}
