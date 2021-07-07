package com.example.PostService.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.DiscriminatorType.STRING;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tip", discriminatorType=STRING)
public abstract class Sadrzaj {
    @Id
    @SequenceGenerator(name="seq_sadrzaj", sequenceName = "seq_sadrzaj", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sadrzaj")
    private Integer id;

    //@ManyToOne( fetch = FetchType.LAZY)
    //private RegistrovaniKorisnik kreator;

    @Column
    private Integer brojreportova;

    @Column
    private Boolean uklonjeno;

    @ManyToMany(mappedBy = "sadrzajlajkovani")
    private Set<RegistrovaniKorisnik> lajkovali = new HashSet<RegistrovaniKorisnik>();

    @ManyToMany(mappedBy = "dislajkovan")
    private Set<RegistrovaniKorisnik> dislajkovali = new HashSet<RegistrovaniKorisnik>();

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Lokacija lokacija;

    @OneToMany(mappedBy = "sadrzaj", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Slika> slike = new HashSet<>();

    @ManyToMany(mappedBy = "sadrzaj", fetch = FetchType.LAZY)
    private Set<Tagovi> tagovi = new HashSet<Tagovi>();

    public Sadrzaj() {
    }

    public Sadrzaj(Integer id, Integer brojreportova, Set<RegistrovaniKorisnik> lajkovali, Set<RegistrovaniKorisnik> dislajkovali, Lokacija lokacija, Set<Slika> slike, Set<Tagovi> tagovi) {
        this.id = id;
        this.brojreportova = brojreportova;
        this.lajkovali = lajkovali;
        this.dislajkovali = dislajkovali;
        this.lokacija = lokacija;
        this.slike = slike;
        this.tagovi = tagovi;
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

    public Set<RegistrovaniKorisnik> getLajkovali() {
        return lajkovali;
    }

    public void setLajkovali(Set<RegistrovaniKorisnik> lajkovali) {
        this.lajkovali = lajkovali;
    }

    public Set<RegistrovaniKorisnik> getDislajkovali() {
        return dislajkovali;
    }

    public void setDislajkovali(Set<RegistrovaniKorisnik> dislajkovali) {
        this.dislajkovali = dislajkovali;
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

    public void setSlike(Set<Slika> slike) {
        this.slike = slike;
    }

    public Set<Slika> getSlike() {
        return slike;
    }

    public Boolean getUklonjeno() {
        return uklonjeno;
    }

    public void setUklonjeno(Boolean uklonjeno) {
        this.uklonjeno = uklonjeno;
    }
}