package com.example.PostService.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.DiscriminatorType.STRING;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tip", discriminatorType=STRING)
public class Sadrzaj {
    @Id
    @SequenceGenerator(name="seq_sadrzaj", sequenceName = "seq_sadrzaj", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sadrzaj")
    private Integer id;


    @ManyToOne( fetch = FetchType.LAZY)
    private RegistrovaniKorisnik kreator;

    @Column
    private Integer brojreportova;

    @ManyToMany(mappedBy = "sadrzajlajkovani")
    private Set<RegistrovaniKorisnik> registrovaniKorisniklajkovan = new HashSet<RegistrovaniKorisnik>();

    @ManyToMany(mappedBy = "dislajkovan")
    private Set<RegistrovaniKorisnik> registrovaniKorisnik = new HashSet<RegistrovaniKorisnik>();


    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Lokacija lokacija;

    @OneToMany(mappedBy = "sadrzaj", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Slika> slike;


    @ManyToMany(mappedBy = "sadrzaj", fetch = FetchType.LAZY)
    private Set<Tagovi> tagovi = new HashSet<Tagovi>();

    public Sadrzaj() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBrojreportova() {
        return brojreportova;
    }

    public void setBrojreportova(Integer brojreportova) {
        this.brojreportova = brojreportova;
    }

    public Set<RegistrovaniKorisnik> getRegistrovaniKorisniklajkovan() {
        return registrovaniKorisniklajkovan;
    }

    public void setRegistrovaniKorisniklajkovan(Set<RegistrovaniKorisnik> registrovaniKorisniklajkovan) {
        this.registrovaniKorisniklajkovan = registrovaniKorisniklajkovan;
    }

    public Set<RegistrovaniKorisnik> getRegistrovaniKorisnik() {
        return registrovaniKorisnik;
    }

    public void setRegistrovaniKorisnik(Set<RegistrovaniKorisnik> registrovaniKorisnik) {
        this.registrovaniKorisnik = registrovaniKorisnik;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    public Set<Tagovi> getTagovi() {
        return tagovi;
    }

    public void setTagovi(Set<Tagovi> tagovi) {
        this.tagovi = tagovi;
    }

    public RegistrovaniKorisnik getKreator() {
        return kreator;
    }

    public void setKreator(RegistrovaniKorisnik kreator) {
        this.kreator = kreator;
    }

    public void setSlike(Set<Slika> slike) {
        this.slike = slike;
    }
}