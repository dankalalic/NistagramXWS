package com.example.settingsservice.dto;

import com.example.settingsservice.model.RegisteredUser;

import java.time.LocalDate;

public class UserChangeDTO {

    private String ime;

    private String eMail;

    private String telefon;

    private String pol;

    private LocalDate datumrodj;

    private String biografija;

    private String websajt;

    private String username;

    public UserChangeDTO() {
    }

    public UserChangeDTO(String ime, String eMail, String telefon, String pol, LocalDate datumrodj, String biografija, String websajt, String username) {
        this.ime = ime;
        this.eMail = eMail;
        this.telefon = telefon;
        this.pol = pol;
        this.datumrodj = datumrodj;
        this.biografija = biografija;
        this.websajt = websajt;
        this.username = username;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
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
}
