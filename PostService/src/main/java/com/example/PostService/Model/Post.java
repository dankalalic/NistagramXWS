package com.example.PostService.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import static javax.persistence.DiscriminatorType.STRING;

@Entity
@DiscriminatorValue("post")
public class Post extends Sadrzaj {

    // @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    //private RegistrovaniKorisnik registrovaniKorisnik;

    public Post() {
    }
}