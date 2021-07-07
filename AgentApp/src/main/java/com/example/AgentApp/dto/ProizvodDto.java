package com.example.AgentApp.dto;

import javax.persistence.Column;

public class ProizvodDto {

    private Integer id;
    private Integer cena;
    private Integer raspolozivoStanje;
    private Integer slika;
    private String naziv;

    public ProizvodDto(Integer id, Integer cena, Integer raspolozivoStanje, Integer slika, String naziv) {
        this.id = id;
        this.cena = cena;
        this.raspolozivoStanje = raspolozivoStanje;
        this.slika = slika;
        this.naziv = naziv;
    }


    public ProizvodDto(Integer id, Integer cena, Integer raspolozivoStanje, String naziv) {
        this.id = id;
        this.cena = cena;
        this.raspolozivoStanje = raspolozivoStanje;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public ProizvodDto() {
    }

    public ProizvodDto(Integer cena, Integer raspolozivoStanje, Integer slika) {
        this.cena = cena;
        this.raspolozivoStanje = raspolozivoStanje;
        this.slika = slika;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    public Integer getRaspolozivoStanje() {
        return raspolozivoStanje;
    }

    public void setRaspolozivoStanje(Integer raspolozivoStanje) {
        this.raspolozivoStanje = raspolozivoStanje;
    }

    public Integer getSlika() {
        return slika;
    }

    public void setSlika(Integer slika) {
        this.slika = slika;
    }

    public ProizvodDto(Integer id, Integer cena, Integer raspolozivoStanje, Integer slika) {
        this.id = id;
        this.cena = cena;
        this.raspolozivoStanje = raspolozivoStanje;
        this.slika = slika;
    }
}
