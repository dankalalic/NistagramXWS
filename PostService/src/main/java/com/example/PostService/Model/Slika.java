package com.example.PostService.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Slika {

    @Id
    @SequenceGenerator(name = "seq_slika", sequenceName = "seq_slika", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_slika")
    private Integer id;

    @Column
    private String url;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Sadrzaj sadrzaj;

    public Slika(Integer id, String url) {
        this.id = id;
        this.url = url;
    }

    public Slika(Integer id, String url, Sadrzaj sadrzaj) {
        this.id = id;
        this.url = url;
        this.sadrzaj = sadrzaj;
    }

    public Slika() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Sadrzaj getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(Sadrzaj sadrzaj) {
        this.sadrzaj = sadrzaj;
    }
}
