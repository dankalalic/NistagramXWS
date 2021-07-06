package com.example.settingsservice.model;

import java.util.HashSet;
import java.util.Set;

public class SadrzajReturnDTO {

    private Integer id;

    private RegisteredUser kreator;

    private Integer brojreportova;

    private Set<RegisteredUser> lajkovali = new HashSet<RegisteredUser>();

    private Set<RegisteredUser> dislajkovali = new HashSet<RegisteredUser>();

    //private Lokacija lokacija;

    //private Set<Slika> slike = new HashSet<>();

    //private Set<Tagovi> tagovi = new HashSet<Tagovi>();

}
