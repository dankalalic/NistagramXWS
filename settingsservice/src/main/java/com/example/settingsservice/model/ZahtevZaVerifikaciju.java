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
    private String slika;

    @Column
    private Boolean status;

    @Column
    private Boolean obradjen;



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

    public ZahtevZaVerifikaciju(Integer id, String slika, Admin admin) {
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

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
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
