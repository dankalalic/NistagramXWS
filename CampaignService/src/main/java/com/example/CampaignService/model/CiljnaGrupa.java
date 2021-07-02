package com.example.CampaignService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CiljnaGrupa {

    @Id
    @SequenceGenerator(name="seq_ciljnaGrupa", sequenceName = "seq_ciljnaGrupa", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ciljnaGrupa")
    private Integer id;

    @Column
    private String pol;

    @Column
    private Integer godinePocetka;

    @Column
    private Integer godineKraja;

    @JsonIgnore
    @OneToMany(mappedBy = "ciljnaGrupa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Kampanja> kampanje;

    public CiljnaGrupa(Integer id, String pol, Integer godinePocetka, Integer godineKraja) {
        this.id = id;
        this.pol = pol;
        this.godinePocetka = godinePocetka;
        this.godineKraja = godineKraja;
    }

    public CiljnaGrupa() {
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

    public Set<Kampanja> getKampanje() {
        return kampanje;
    }

    public void setKampanje(Set<Kampanja> kampanje) {
        this.kampanje = kampanje;
    }
}
