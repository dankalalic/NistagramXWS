package com.example.settingsservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User{

    @JsonIgnore
    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ZahtevZaRegistraciju> zahteviZaRegistraciju = new HashSet<ZahtevZaRegistraciju>();

    @JsonIgnore
    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ZahtevZaVerifikaciju> zahteviZaVerifikaciju = new HashSet<ZahtevZaVerifikaciju>();

    public Set<ZahtevZaRegistraciju> getZahteviZaRegistraciju() {
        return zahteviZaRegistraciju;
    }

    public void setZahteviZaRegistraciju(Set<ZahtevZaRegistraciju> zahteviZaRegistraciju) {
        this.zahteviZaRegistraciju = zahteviZaRegistraciju;
    }

    public Set<ZahtevZaVerifikaciju> getZahteviZaVerifikaciju() {
        return zahteviZaVerifikaciju;
    }

    public void setZahteviZaVerifikaciju(Set<ZahtevZaVerifikaciju> zahteviZaVerifikaciju) {
        this.zahteviZaVerifikaciju = zahteviZaVerifikaciju;
    }
}
