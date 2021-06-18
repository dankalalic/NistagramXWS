package com.example.PostService.Model;


import javax.persistence.*;

@Entity
@Table(name="komentar")
public class Komentar {

    @Id
    @SequenceGenerator(name="seq_komentar", sequenceName = "seq_komentar", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_komentar")
    private Integer id;

    @Column
    private String text;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private RegistrovaniKorisnik registrovaniKorisnik;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Sadrzaj sadrzaj;

    public Komentar() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public RegistrovaniKorisnik getRegistrovaniKorisnik() {
        return registrovaniKorisnik;
    }

    public void setRegistrovaniKorisnik(RegistrovaniKorisnik registrovaniKorisnik) {
        this.registrovaniKorisnik = registrovaniKorisnik;
    }

    public Sadrzaj getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(Sadrzaj sadrzaj) {
        this.sadrzaj = sadrzaj;
    }
}
