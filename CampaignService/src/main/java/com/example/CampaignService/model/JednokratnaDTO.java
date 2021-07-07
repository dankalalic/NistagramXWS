package com.example.CampaignService.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Lob;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class JednokratnaDTO {

    private Integer id;
    private String pol;
    private Integer godinePocetka;
    private Integer godineKraja;
    @Lob
    private List<Slika> slike;
    //private List<String> linkovi;
    private LocalDateTime pocetakPrikazivanja;
    private LocalDateTime krajPrikazivanja;

    public JednokratnaDTO() {
    }

    public JednokratnaDTO(String pol, Integer godinePocetka, Integer godineKraja, List<Slika> slike, LocalDateTime pocetakPrikazivanja, LocalDateTime krajPrikazivanja) {
        this.pol = pol;
        this.godinePocetka = godinePocetka;
        this.godineKraja = godineKraja;
        this.slike = slike;
        this.pocetakPrikazivanja = pocetakPrikazivanja;
        this.krajPrikazivanja = krajPrikazivanja;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    /*public List<String> getLinkovi() {
        return linkovi;
    }

    public void setLinkovi(List<String> linkovi) {
        this.linkovi = linkovi;
    }*/

    public LocalDateTime getPocetakPrikazivanja() {
        return pocetakPrikazivanja;
    }

    public void setPocetakPrikazivanja(LocalDateTime pocetakPrikazivanja) {
        this.pocetakPrikazivanja = pocetakPrikazivanja;
    }

    public LocalDateTime getKrajPrikazivanja() {
        return krajPrikazivanja;
    }

    public void setKrajPrikazivanja(LocalDateTime krajPrikazivanja) {
        this.krajPrikazivanja = krajPrikazivanja;
    }
}
