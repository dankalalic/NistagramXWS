package com.example.settingsservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ZahtevZaVerifikaciju {

    @Id
    @SequenceGenerator(name="seq_zahtevi_verifikacija", sequenceName = "seq_zahtevi_verifikacija", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_zahtevi_verifikacija")
    private Integer id;

    @Column
    private Integer slika;

    @Column
    private Boolean status;

    @Column
    private Boolean obradjen;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String kategorija;


    public ZahtevZaVerifikaciju(Integer id, Integer slika, Boolean status, Boolean obradjen, String ime, String prezime, String kategorija) {
        this.id = id;
        this.slika = slika;
        this.status = status;
        this.obradjen = obradjen;
        this.ime = ime;
        this.prezime = prezime;
        this.kategorija = kategorija;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Admin admin;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registeredUser_id", referencedColumnName = "id")
    private RegisteredUser registeredUser;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private KategorijaProfila kategorijaProfila;

    public ZahtevZaVerifikaciju() {
    }

    public ZahtevZaVerifikaciju(Integer id, Integer slika, Admin admin) {
        this.id = id;
        this.slika = slika;
        this.admin = admin;
        this.obradjen=false;

    }

    public Boolean getObradjen() {
        return obradjen;
    }

    public void setObradjen(Boolean obradjen) {
        this.obradjen = obradjen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSlika() {
        return slika;
    }

    public void setSlika(Integer slika) {
        this.slika = slika;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
    }

    public KategorijaProfila getKategorijaProfila() {
        return kategorijaProfila;
    }

    public void setKategorijaProfila(KategorijaProfila kategorijaProfila) {
        this.kategorijaProfila = kategorijaProfila;
    }
}
