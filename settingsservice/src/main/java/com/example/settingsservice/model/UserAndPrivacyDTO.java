package com.example.settingsservice.model;

import java.time.LocalDate;

public class UserAndPrivacyDTO {
    private Integer id;

    private String lozinka;

    private String ime;

    private String prezime;

    private String eMail;

    private String telefon;

    private String pol;

    private LocalDate datumrodj;

    private String biografija;

    private String websajt;

    private String username;

    private Boolean allowNotifs;
    private Boolean isp;
    private Boolean acceptMsg;
    private Boolean taggable;

    public UserAndPrivacyDTO(Integer id, String lozinka, String ime, String prezime, String eMail, String telefon, String pol, LocalDate datumrodj, String biografija, String websajt, String username, Boolean allowNotifs, Boolean isp, Boolean acceptMsg, Boolean taggable) {
        this.id = id;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.eMail = eMail;
        this.telefon = telefon;
        this.pol = pol;
        this.datumrodj = datumrodj;
        this.biografija = biografija;
        this.websajt = websajt;
        this.username = username;
        this.allowNotifs = allowNotifs;
        this.isp = isp;
        this.acceptMsg = acceptMsg;
        this.taggable = taggable;
    }

    public UserAndPrivacyDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getAllowNotifs() {
        return allowNotifs;
    }

    public void setAllowNotifs(Boolean allowNotifs) {
        this.allowNotifs = allowNotifs;
    }

    public Boolean getIsp() {
        return isp;
    }

    public void setIsp(Boolean isp) {
        this.isp = isp;
    }

    public Boolean getAcceptMsg() {
        return acceptMsg;
    }

    public void setAcceptMsg(Boolean acceptMsg) {
        this.acceptMsg = acceptMsg;
    }

    public Boolean getTaggable() {
        return taggable;
    }

    public void setTaggable(Boolean taggable) {
        this.taggable = taggable;
    }
}
