package com.example.settingsservice.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("agent")
public class Agent extends RegisteredUser{

}
