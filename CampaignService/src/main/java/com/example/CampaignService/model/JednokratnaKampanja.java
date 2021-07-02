package com.example.CampaignService.model;

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
    private LocalDateTime vremePrikazivanja;

    public JednokratnaKampanja(LocalDateTime vremePrikazivanja) {
        this.vremePrikazivanja = vremePrikazivanja;
    }

    public JednokratnaKampanja() {
    }

    public LocalDateTime getVremePrikazivanja() {
        return vremePrikazivanja;
    }

    public void setVremePrikazivanja(LocalDateTime vremePrikazivanja) {
        this.vremePrikazivanja = vremePrikazivanja;
    }
}
