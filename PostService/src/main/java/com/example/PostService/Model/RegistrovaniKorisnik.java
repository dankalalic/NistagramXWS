package com.example.PostService.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RegistrovaniKorisnik {

    @Id
    @SequenceGenerator(name="seq_registrovanikorisnik", sequenceName = "seq_registrovanikorisnik", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_registrovanikorisnik")
    private Integer id;


    @OneToMany(mappedBy = "registrovaniKorisnik", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Post> posts;


    @OneToMany(mappedBy = "registrovaniKorisnik", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Komentar> komentari;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "lajkovali", joinColumns = @JoinColumn(name = "sadrzajlajkovani_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "registrovaniKorisniklajkovan_id", referencedColumnName = "id"))
    private Set<Sadrzaj> sadrzajlajkovani = new HashSet<Sadrzaj>();


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "dislajkovali", joinColumns = @JoinColumn(name = "dislajkovan_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "registrovaniKorisnik_id", referencedColumnName = "id"))
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
}
