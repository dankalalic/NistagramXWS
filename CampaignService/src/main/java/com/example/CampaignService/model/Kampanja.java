package com.example.CampaignService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tip")
public class Kampanja {

    @Id
    @SequenceGenerator(name="seq_camp", sequenceName = "seq_camp", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_camp")
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Agent agent;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private CiljnaGrupa ciljnaGrupa;

    @JsonIgnore
    @OneToMany(mappedBy = "kampanja", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Reklama> reklame;



    public Kampanja(Integer id) {
        this.id = id;
    }

    public Kampanja() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public CiljnaGrupa getCiljnaGrupa() {
        return ciljnaGrupa;
    }

    public void setCiljnaGrupa(CiljnaGrupa ciljnaGrupa) {
        this.ciljnaGrupa = ciljnaGrupa;
    }

    public Set<Reklama> getReklame() {
        return reklame;
    }

    public void setReklame(Set<Reklama> reklame) {
        this.reklame = reklame;
    }
}
