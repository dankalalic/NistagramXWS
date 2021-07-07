package com.example.CampaignService.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Time;
import java.time.DateTimeException;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("jednokratna")
public class JednokratnaKampanja extends Kampanja{

    //promenite ako smeta ne znam kako treba
    @Column
    private LocalDateTime pocetakPrikazivanja;

    @Column
    private LocalDateTime krajPrikazivanja;

    public JednokratnaKampanja(LocalDateTime pocetakPrikazivanja, LocalDateTime krajPrikazivanja) {
        this.pocetakPrikazivanja = pocetakPrikazivanja;
        this.krajPrikazivanja = krajPrikazivanja;
    }

    public JednokratnaKampanja(LocalDateTime pocetakPrikazivanja) {
        this.pocetakPrikazivanja = pocetakPrikazivanja;
    }

    public JednokratnaKampanja() {
    }

    public LocalDateTime getPocetakPrikazivanja() {
        return pocetakPrikazivanja;
    }

    public void setPocetakPrikazivanja(LocalDateTime pocetakPrikazivanja) {
        this.pocetakPrikazivanja = pocetakPrikazivanja;
    }

    public LocalDateTime getKrajPrikazivanja() {
        return krajPrikazivanja;
    }

    public void setKrajPrikazivanja(LocalDateTime krajPrikazivanja) {
        this.krajPrikazivanja = krajPrikazivanja;
    }
}
