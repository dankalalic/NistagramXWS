package com.example.settingsservice.dto;

public class ZahtevZaVerifikacijudto {

    private String ime;
    private String prezime;
    private String kategorija;
    private Integer slika ;

    public ZahtevZaVerifikacijudto() {
    }

    public ZahtevZaVerifikacijudto(String ime, String prezime, String kategorija, Integer slika) {
        this.ime = ime;
        this.prezime = prezime;
        this.kategorija = kategorija;
        this.slika = slika;
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

    public Integer getSlika() {
        return slika;
    }

    public void setSlika(Integer slika) {
        this.slika = slika;
    }
}
