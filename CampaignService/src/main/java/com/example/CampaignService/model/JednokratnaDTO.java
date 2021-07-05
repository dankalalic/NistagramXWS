package com.example.CampaignService.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Lob;
import java.util.Date;
import java.util.List;

public class JednokratnaDTO {

    private String pol;
    private Integer godinePocetka;
    private Integer godineKraja;
    @Lob
    private MultipartFile[] slike;
    private List<String> linkovi;
    private Date datumPrikazivanja;

    public JednokratnaDTO() {
    }

    public JednokratnaDTO(String pol, Integer godinePocetka, Integer godineKraja, MultipartFile[] slike, List<String> linkovi, Date datumPrikazivanja) {
        this.pol = pol;
        this.godinePocetka = godinePocetka;
        this.godineKraja = godineKraja;
        this.slike = slike;
        this.linkovi = linkovi;
        this.datumPrikazivanja = datumPrikazivanja;
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

    public MultipartFile[] getSlike() {
        return slike;
    }

    public void setSlike(MultipartFile[] slike) {
        this.slike = slike;
    }

    public List<String> getLinkovi() {
        return linkovi;
    }

    public void setLinkovi(List<String> linkovi) {
        this.linkovi = linkovi;
    }

    public Date getDatumPrikazivanja() {
        return datumPrikazivanja;
    }

    public void setDatumPrikazivanja(Date datumPrikazivanja) {
        this.datumPrikazivanja = datumPrikazivanja;
    }
}
