package com.example.PostService.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Sadrzaj {
    @Id
    @SequenceGenerator(name="seq_sadrzaj", sequenceName = "seq_sadrzaj", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sadrzaj")
    private Integer id;

    @ElementCollection
    private Set<String> slike = new HashSet<String>();

    @Column
    private Integer brojreportova;

    @ManyToMany(mappedBy = "sadrzajlajkovani")
    private Set<RegistrovaniKorisnik> registrovaniKorisniklajkovan = new HashSet<RegistrovaniKorisnik>();

    @ManyToMany(mappedBy = "dislajkovan")
    private Set<RegistrovaniKorisnik> registrovaniKorisnik = new HashSet<RegistrovaniKorisnik>();

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Lokacija lokacija;

    @ManyToMany(mappedBy = "sadrzaj", fetch = FetchType.EAGER)
    private Set<Tagovi> tagovi = new HashSet<Tagovi>();

    public Sadrzaj() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<String> getSlike() {
        return slike;
    }

    public void setSlike(Set<String> slike) {
        this.slike = slike;
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
}
