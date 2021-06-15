package com.example.settingsservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class KategorijaProfila {

    @Id
    private Integer id;

    @Column
    private String naziv;

    @JsonIgnore
    @OneToMany(mappedBy = "kategorijaProfila", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ZahtevZaVerifikaciju> zahteviZaVerifikaciju = new HashSet<ZahtevZaVerifikaciju>();


    public KategorijaProfila() {
    }

    public KategorijaProfila(Integer id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Set<ZahtevZaVerifikaciju> getZahteviZaVerifikaciju() {
        return zahteviZaVerifikaciju;
    }

    public void setZahteviZaVerifikaciju(Set<ZahtevZaVerifikaciju> zahteviZaVerifikaciju) {
        this.zahteviZaVerifikaciju = zahteviZaVerifikaciju;
    }
}
