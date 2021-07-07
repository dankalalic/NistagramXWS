package com.example.settingsservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ZahtevZaRegistraciju {

    @Id
    @SequenceGenerator(name="seq_zahtevi_registracija", sequenceName = "seq_zahtevi_registracija", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_zahtevi_registracija")
    private Integer id;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "registeredUser_id", referencedColumnName = "id")
    private RegisteredUser registeredUser;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Admin admin;

    @Column
    private Boolean odobren;

    public ZahtevZaRegistraciju() {
    }

    public ZahtevZaRegistraciju(Integer id, RegisteredUser registeredUser, Admin admin, Boolean odobren) {
        this.id = id;
        this.registeredUser = registeredUser;
        this.admin = admin;
        this.odobren = odobren;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Boolean getOdobren() {
        return odobren;
    }

    public void setOdobren(Boolean odobren) {
        this.odobren = odobren;
    }
}
