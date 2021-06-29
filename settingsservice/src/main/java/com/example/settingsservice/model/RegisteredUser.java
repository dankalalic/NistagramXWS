package com.example.settingsservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("registeredUser")
public class RegisteredUser extends User{

    public enum EnumPol{
        Musko,
        Zensko
    }

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String eMail;

    @Column
    private String telefon;

    @Column
    private String pol;

    @Column
    private LocalDate datumrodj;

    @Column
    private String biografija;

    @Column
    private String websajt;

    @Column
    private Boolean dozvoljenoTagovanje;

    @Column
    private Boolean dozvoljeneNotifikacije;

    @Column
    private Boolean prihvataPoruke;

    @Column
    private Boolean isPrivate;

    @JsonIgnore
    @OneToMany(mappedBy = "saljeZahtev", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ZahteviZaPracenje> poslati = new HashSet<ZahteviZaPracenje>();

    @JsonIgnore
    @OneToMany(mappedBy = "primaZahtev", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ZahteviZaPracenje> primljeni = new HashSet<ZahteviZaPracenje>();

    @OneToOne(mappedBy = "registeredUser")
    private ZahtevZaRegistraciju zahtevZaRegistraciju;

    @OneToOne(mappedBy = "registeredUser")
    private ZahtevZaVerifikaciju zahtevZaRVerifikaciju;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="UserBlok",
            joinColumns={@JoinColumn(name="jaBlokiraoId")},
            inverseJoinColumns={@JoinColumn(name="meneBlokiraliId")})
    private Set<RegisteredUser> jaBlokirao = new HashSet<RegisteredUser>();

    @JsonIgnore
    @ManyToMany(mappedBy = "jaBlokirao")
    private Set<RegisteredUser> meneBlokirali = new HashSet<RegisteredUser>();

    public RegisteredUser() {
    }

    public RegisteredUser(String ime, String prezime, String eMail, String telefon, LocalDate datumrodj, String biografija, String websajt, Boolean dozvoljenoTagovanje, Boolean dozvoljeneNotifikacije) {
        this.ime = ime;
        this.prezime = prezime;
        this.eMail = eMail;
        this.telefon = telefon;
        this.datumrodj = datumrodj;
        this.biografija = biografija;
        this.websajt = websajt;
        this.dozvoljenoTagovanje = dozvoljenoTagovanje;
        this.dozvoljeneNotifikacije = dozvoljeneNotifikacije;
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public LocalDate getDatumrodj() {
        return datumrodj;
    }

    public void setDatumrodj(LocalDate datumrodj) {
        this.datumrodj = datumrodj;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

    public String getWebsajt() {
        return websajt;
    }

    public void setWebsajt(String websajt) {
        this.websajt = websajt;
    }

    public Boolean getDozvoljenoTagovanje() {
        return dozvoljenoTagovanje;
    }

    public void setDozvoljenoTagovanje(Boolean dozvoljenoTagovanje) {
        this.dozvoljenoTagovanje = dozvoljenoTagovanje;
    }

    public Boolean getDozvoljeneNotifikacije() {
        return dozvoljeneNotifikacije;
    }

    public void setDozvoljeneNotifikacije(Boolean dozvoljeneNotifikacije) {
        this.dozvoljeneNotifikacije = dozvoljeneNotifikacije;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public Set<ZahteviZaPracenje> getPoslati() {
        return poslati;
    }

    public void setPoslati(Set<ZahteviZaPracenje> poslati) {
        this.poslati = poslati;
    }

    public Set<ZahteviZaPracenje> getPrimljeni() {
        return primljeni;
    }

    public void setPrimljeni(Set<ZahteviZaPracenje> primljeni) {
        this.primljeni = primljeni;
    }

    public ZahtevZaRegistraciju getZahtevZaRegistraciju() {
        return zahtevZaRegistraciju;
    }

    public void setZahtevZaRegistraciju(ZahtevZaRegistraciju zahtevZaRegistraciju) {
        this.zahtevZaRegistraciju = zahtevZaRegistraciju;
    }

    public ZahtevZaVerifikaciju getZahtevZaRVerifikaciju() {
        return zahtevZaRVerifikaciju;
    }

    public void setZahtevZaRVerifikaciju(ZahtevZaVerifikaciju zahtevZaRVerifikaciju) {
        this.zahtevZaRVerifikaciju = zahtevZaRVerifikaciju;
    }

    public Set<RegisteredUser> getJaBlokirao() {
        return jaBlokirao;
    }

    public void setJaBlokirao(Set<RegisteredUser> jaBlokirao) {
        this.jaBlokirao = jaBlokirao;
    }

    public Set<RegisteredUser> getMeneBlokirali() {
        return meneBlokirali;
    }

    public void setMeneBlokirali(Set<RegisteredUser> meneBlokirali) {
        this.meneBlokirali = meneBlokirali;
    }

    public Boolean getPrihvataPoruke() {
        return prihvataPoruke;
    }

    public void setPrihvataPoruke(Boolean prihvataPoruke) {
        this.prihvataPoruke = prihvataPoruke;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }
}
