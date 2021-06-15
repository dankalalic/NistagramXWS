package com.example.PostService.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Tagovi {

    @Id
    @SequenceGenerator(name="seq_tagovi", sequenceName = "seq_tagovi", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tagovi")
    private Integer id;

    @Column(unique = true)
    private String naziv;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tagovani", joinColumns = @JoinColumn(name = "tagovi_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "sadrzaj_id", referencedColumnName = "id"))
    private Set<Sadrzaj> sadrzaj = new HashSet<Sadrzaj>();

    public Tagovi() {
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