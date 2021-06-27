package com.example.PostService.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RegistrovaniKorisnik {

    @Id
    private Integer id;

    @Column(unique = true)
    private String username;

    @JsonIgnore
    @OneToMany(mappedBy = "kreator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Post> posts;

    @OneToMany(mappedBy = "registrovaniKorisnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Komentar> komentari;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "lajkovali", joinColumns = @JoinColumn(name = "registrovaniKorisniklajkovan_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "sadrzajlajkovani_id", referencedColumnName = "id"))
    private Set<Sadrzaj> sadrzajlajkovani = new HashSet<Sadrzaj>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "dislajkovali", joinColumns = @JoinColumn(name = "registrovaniKorisnik_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "dislajkovan_id", referencedColumnName = "id"))
    private Set<Sadrzaj> dislajkovan = new HashSet<Sadrzaj>();

    public RegistrovaniKorisnik() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Komentar> getKomentari() {
        return komentari;
    }

    public void setKomentari(Set<Komentar> komentari) {
        this.komentari = komentari;
    }

    public Set<Sadrzaj> getSadrzajlajkovani() {
        return sadrzajlajkovani;
    }

    public void setSadrzajlajkovani(Set<Sadrzaj> sadrzajlajkovani) {
        this.sadrzajlajkovani = sadrzajlajkovani;
    }

    public Set<Sadrzaj> getDislajkovan() {
        return dislajkovan;
    }

    public void setDislajkovan(Set<Sadrzaj> dislajkovan) {
        this.dislajkovan = dislajkovan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}