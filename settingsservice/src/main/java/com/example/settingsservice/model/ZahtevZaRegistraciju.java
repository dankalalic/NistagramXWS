package com.example.settingsservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ZahtevZaRegistraciju {

    @Id
    private Integer id;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registeredUser_id", referencedColumnName = "id")
    private RegisteredUser registeredUser;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Admin admin;

    public ZahtevZaRegistraciju() {
    }

    public ZahtevZaRegistraciju(Integer id) {
        this.id = id;
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
}
