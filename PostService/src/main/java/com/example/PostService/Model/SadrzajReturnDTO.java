package com.example.PostService.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class SadrzajReturnDTO {

    private Integer id;

    private RegistrovaniKorisnik kreator;

    private Integer brojreportova;

    private Set<RegistrovaniKorisnik> lajkovali = new HashSet<RegistrovaniKorisnik>();

    private Set<RegistrovaniKorisnik> dislajkovali = new HashSet<RegistrovaniKorisnik>();

    private Lokacija lokacija;

    private Set<Slika> slike = new HashSet<>();

    private Set<Tagovi> tagovi = new HashSet<Tagovi>();

    public SadrzajReturnDTO() {
    }

    public SadrzajReturnDTO(Integer id, RegistrovaniKorisnik kreator, Integer brojreportova, Set<RegistrovaniKorisnik> lajkovali, Set<RegistrovaniKorisnik> dislajkovali, Lokacija lokacija, Set<Slika> slike, Set<Tagovi> tagovi) {
        this.id = id;
        this.kreator = kreator;
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

    public RegistrovaniKorisnik getKreator() {
        return kreator;
    }

    public void setKreator(RegistrovaniKorisnik kreator) {
        this.kreator = kreator;
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

    public Set<Slika> getSlike() {
        return slike;
    }

    public void setSlike(Set<Slika> slike) {
        this.slike = slike;
    }

    public Set<Tagovi> getTagovi() {
        return tagovi;
    }

    public void setTagovi(Set<Tagovi> tagovi) {
        this.tagovi = tagovi;
    }
}
