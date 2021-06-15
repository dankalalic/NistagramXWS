package com.example.settingsservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ZahteviZaPracenje {

    @Id
    private Integer id;

    @Column
    private Boolean odobren;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RegisteredUser saljeZahtev;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RegisteredUser primaZahtev;

    public ZahteviZaPracenje() {
    }

    public ZahteviZaPracenje(Integer id, Boolean odobren) {
        this.id = id;
        this.odobren = odobren;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getOdobren() {
        return odobren;
    }

    public void setOdobren(Boolean odobren) {
        this.odobren = odobren;
    }

    public RegisteredUser getSaljeZahtev() {
        return saljeZahtev;
    }

    public void setSaljeZahtev(RegisteredUser saljeZahtev) {
        this.saljeZahtev = saljeZahtev;
    }

    public RegisteredUser getPrimaZahtev() {
        return primaZahtev;
    }

    public void setPrimaZahtev(RegisteredUser primaZahtev) {
        this.primaZahtev = primaZahtev;
    }
}
