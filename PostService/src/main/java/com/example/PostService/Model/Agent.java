package com.example.PostService.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("agent")
public class Agent extends RegistrovaniKorisnik{

    @JsonIgnore
    @OneToMany(mappedBy = "kreator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Reklama> reklame;

    public Set<Reklama> getReklame() {
        return reklame;
    }

    public void setReklame(Set<Reklama> reklame) {
        this.reklame = reklame;
    }
}
