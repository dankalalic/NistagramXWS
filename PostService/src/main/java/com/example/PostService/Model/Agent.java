package com.example.PostService.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("agent")
public class Agent extends RegistrovaniKorisnik{
}
