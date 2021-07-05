package com.example.PostService.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("reklama")
public class Reklama extends Sadrzaj{

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Agent kreator;

    public Reklama() {
    }

    public Reklama(Integer id, Integer brojreportova, Set<RegistrovaniKorisnik> lajkovali, Set<RegistrovaniKorisnik> dislajkovali, Lokacija lokacija, Set<Slika> slike, Set<Tagovi> tagovi, Agent kreator) {
        super(id, brojreportova, lajkovali, dislajkovali, lokacija, slike, tagovi);
        this.kreator = kreator;
    }

    public Agent getKreator() {
        return kreator;
    }

    public void setKreator(Agent kreator) {
        this.kreator = kreator;
    }
}
