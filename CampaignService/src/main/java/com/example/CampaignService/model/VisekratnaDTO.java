package com.example.CampaignService.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.util.Date;
import java.util.List;

public class VisekratnaDTO {
    private String pol;
    private Integer godinePocetka;
    private Integer godineKraja;
    @Lob
    private List<Slika> slike;
    //private List<String> linkovi;
    private Date pocetakPrikazivanja;
    private Date krajPrikazivanja;
    private Integer potrebanBrojPrikazivanja;

    public VisekratnaDTO(String pol, Integer godinePocetka, Integer godineKraja, List<Slika> slike, Date pocetakPrikazivanja, Date krajPrikazivanja, Integer potrebanBrojPrikazivanja) {
        this.pol = pol;
        this.godinePocetka = godinePocetka;
        this.godineKraja = godineKraja;
        this.slike = slike;
        this.pocetakPrikazivanja = pocetakPrikazivanja;
        this.krajPrikazivanja = krajPrikazivanja;
        this.potrebanBrojPrikazivanja = potrebanBrojPrikazivanja;
    }

    public VisekratnaDTO() {
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public Integer getGodinePocetka() {
        return godinePocetka;
    }

    public void setGodinePocetka(Integer godinePocetka) {
        this.godinePocetka = godinePocetka;
    }

    public Integer getGodineKraja() {
        return godineKraja;
    }

    public void setGodineKraja(Integer godineKraja) {
        this.godineKraja = godineKraja;
    }

    public List<Slika> getSlike() {
        return slike;
    }

    public void setSlike(List<Slika> slike) {
        this.slike = slike;
    }

    public Date getPocetakPrikazivanja() {
        return pocetakPrikazivanja;
    }

    public void setPocetakPrikazivanja(Date pocetakPrikazivanja) {
        this.pocetakPrikazivanja = pocetakPrikazivanja;
    }

    public Date getKrajPrikazivanja() {
        return krajPrikazivanja;
    }

    public void setKrajPrikazivanja(Date krajPrikazivanja) {
        this.krajPrikazivanja = krajPrikazivanja;
    }

    public Integer getPotrebanBrojPrikazivanja() {
        return potrebanBrojPrikazivanja;
    }

    public void setPotrebanBrojPrikazivanja(Integer potrebanBrojPrikazivanja) {
        this.potrebanBrojPrikazivanja = potrebanBrojPrikazivanja;
    }
}
