package com.example.messagesservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class User {


    @Id
    private Integer id;

    @OneToMany(mappedBy = "userSalje")
    private List<Poruka> porukaSalje;

    @OneToMany(mappedBy = "userPrima")
    private  List<Poruka> porukaPrima;


    public User(Integer id) {
        this.id = id;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
