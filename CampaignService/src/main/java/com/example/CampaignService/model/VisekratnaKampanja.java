package com.example.CampaignService.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("visekratna")
public class VisekratnaKampanja extends Kampanja{

    @Column
    private Date pocetakPrikazivanja;

    @Column
    private Date krajPrikazivanja;

    @Column
    private Integer potrebanBrojPrikazivanja;

    @Column
    private Integer trenutanBrojPrikazivanja;

    public VisekratnaKampanja(Date pocetakPrikazivanja, Date krajPrikazivanja, Integer potrebanBrojPrikazivanja, Integer trenutanBrojPrikazivanja) {
        this.pocetakPrikazivanja = pocetakPrikazivanja;
        this.krajPrikazivanja = krajPrikazivanja;
        this.potrebanBrojPrikazivanja = potrebanBrojPrikazivanja;
        this.trenutanBrojPrikazivanja = trenutanBrojPrikazivanja;
    }

    public VisekratnaKampanja() {
    }

    public Date getPocetakPrikazivanja() {
        return pocetakPrikazivanja;
    }

    public void setPocetakPrikazivanja(Date pocetakPrikazivanja) {
        this.pocetakPrikazivanja = pocetakPrikazivanja;
    }

    public Date getKrajPrikazivanja() {
        return krajPrikazivanja;
    }

    public void setKrajPrikazivanja(Date krajPrikazivanja) {
        this.krajPrikazivanja = krajPrikazivanja;
    }

    public Integer getPotrebanBrojPrikazivanja() {
        return potrebanBrojPrikazivanja;
    }

    public void setPotrebanBrojPrikazivanja(Integer potrebanBrojPrikazivanja) {
        this.potrebanBrojPrikazivanja = potrebanBrojPrikazivanja;
    }

    public Integer getTrenutanBrojPrikazivanja() {
        return trenutanBrojPrikazivanja;
    }

    public void setTrenutanBrojPrikazivanja(Integer trenutanBrojPrikazivanja) {
        this.trenutanBrojPrikazivanja = trenutanBrojPrikazivanja;
    }
}
