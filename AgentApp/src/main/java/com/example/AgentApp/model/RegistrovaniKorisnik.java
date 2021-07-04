package com.example.AgentApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RegistrovaniKorisnik {
    @Id
    private Integer id;

    @OneToMany(mappedBy = "registrovaniKorisnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Narudzbina> narudzbina;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "korpa_id", referencedColumnName = "id")
    private Korpa korpa;

    public Korpa getKorpa() {
        return korpa;
    }

    public void setKorpa(Korpa korpa) {
        this.korpa = korpa;
    }

    public RegistrovaniKorisnik(Integer id, Set<Narudzbina> narudzbina) {
        this.id = id;
        this.narudzbina = narudzbina;
    }

    public RegistrovaniKorisnik() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Narudzbina> getNarudzbina() {
        return narudzbina;
    }

    public void setNarudzbina(Set<Narudzbina> narudzbina) {
        this.narudzbina = narudzbina;
    }
}
