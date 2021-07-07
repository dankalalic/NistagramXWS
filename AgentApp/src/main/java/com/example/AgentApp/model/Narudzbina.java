package com.example.AgentApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Narudzbina {
    @Id
    @SequenceGenerator(name = "seq_narudzbina", sequenceName = "seq_narudzbina", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_narudzbina")
    private Integer id;

    @Column
    private Integer kolicina;


    @Column
    private Date datum;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private RegistrovaniKorisnik registrovaniKorisnik;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "proizvodi", joinColumns = @JoinColumn(name = "narudzbina_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "proizvod_id", referencedColumnName = "id"))
    private Set<Proizvod> proizvod = new HashSet<Proizvod>();

    public Narudzbina() {
    }


    public Narudzbina(Integer id, Integer kolicina, Date datum, RegistrovaniKorisnik registrovaniKorisnik, Set<Proizvod> proizvod) {
        this.id = id;
        this.kolicina = kolicina;
        this.datum = datum;
        this.registrovaniKorisnik = registrovaniKorisnik;
        this.proizvod = proizvod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public RegistrovaniKorisnik getRegistrovaniKorisnik() {
        return registrovaniKorisnik;
    }

    public void setRegistrovaniKorisnik(RegistrovaniKorisnik registrovaniKorisnik) {
        this.registrovaniKorisnik = registrovaniKorisnik;
    }

    public Set<Proizvod> getProizvod() {
        return proizvod;
    }

    public void setProizvod(Set<Proizvod> proizvod) {
        this.proizvod = proizvod;
    }
}
