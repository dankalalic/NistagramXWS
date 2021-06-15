package com.example.PostService.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Lokacija {
    @Id
    @SequenceGenerator(name="seq_post", sequenceName = "seq_post", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
    private Integer id;

    @Column(unique = true)
    private String naziv;

    @JsonIgnore
    @OneToMany(mappedBy = "lokacija", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sadrzaj> sadrzaj;

    public Lokacija() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Set<Sadrzaj> getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(Set<Sadrzaj> sadrzaj) {
        this.sadrzaj = sadrzaj;
    }
}
