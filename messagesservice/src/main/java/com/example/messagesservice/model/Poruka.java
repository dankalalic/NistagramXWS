package com.example.messagesservice.model;

import javax.persistence.*;

@Entity
public class Poruka {

    @Id
    @SequenceGenerator(name = "seq_poruka", sequenceName = "seq_poruka", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_poruka")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_salje_id")
    private User userSalje;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_prima_id")
    private User userPrima;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    @Column
    private String tekst;

    public Poruka() {
    }

    public Poruka(User userSalje, User userPrima, String tekst) {
        this.userSalje = userSalje;
        this.userPrima = userPrima;
        this.tekst = tekst;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserSalje() {
        return userSalje;
    }

    public void setUserSalje(User userSalje) {
        this.userSalje = userSalje;
    }

    public User getUserPrima() {
        return userPrima;
    }

    public void setUserPrima(User userPrima) {
        this.userPrima = userPrima;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}
