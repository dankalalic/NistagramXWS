package com.example.settingsservice.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("agent")
public class Agent extends RegisteredUser{


    public Agent() {
    }

    public Agent(String ime, String prezime, String eMail, String telefon, LocalDate datumrodj, String biografija, String websajt, Boolean dozvoljenoTagovanje, Boolean dozvoljeneNotifikacije) {
        super(ime, prezime, eMail, telefon, datumrodj, biografija, websajt, dozvoljenoTagovanje, dozvoljeneNotifikacije);
    }



}
