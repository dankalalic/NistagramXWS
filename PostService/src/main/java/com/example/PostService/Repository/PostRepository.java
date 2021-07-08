package com.example.PostService.Repository;

import com.example.PostService.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface PostRepository extends JpaRepository<Post,Integer> {

    //Set<Post> findAllByRegistrovaniKorisnik(RegistrovaniKorisnik registraniKorisnik);

    List<Post> findByKreator(RegistrovaniKorisnik registrovaniKorisnik);
    Post findOneById(Integer id);

    List<Post> findByLokacija(Lokacija lokacija);

    List<Post> findByTagovi(Tagovi tag);
}
