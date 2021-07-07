package com.example.settingsservice.model;

public class ZahteviReturnDTO {

    private Integer id;
    private String ime;
    private String prezime;
    private String username;
    private String email;
    private String websajt;

    public ZahteviReturnDTO() {
    }

    public ZahteviReturnDTO(String ime, String prezime, String username, String email, String websajt) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.email = email;
        this.websajt = websajt;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsajt() {
        return websajt;
    }

    public void setWebsajt(String websajt) {
        this.websajt = websajt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
