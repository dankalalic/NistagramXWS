package com.example.CampaignService.model;

import javax.persistence.*;

@Entity
public class Reklama {

    @Id
    private Integer id;

    @Column
    private String link;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Kampanja kampanja;

    public Reklama(Integer id, String link) {
        this.id = id;
        this.link = link;
    }

    public Reklama() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Kampanja getKampanja() {
        return kampanja;
    }

    public void setKampanja(Kampanja kampanja) {
        this.kampanja = kampanja;
    }
}
