package com.example.messagesservice.model;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Post {

    @Id
    @SequenceGenerator(name = "seq_post", sequenceName = "seq_post", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
    private Integer id;

    @OneToMany(mappedBy="post")
    private List<Poruka> poruke;

}
