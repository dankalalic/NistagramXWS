package com.example.PostService.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("reklama")
public class Reklama extends Sadrzaj{


    public Reklama() {
    }
}
