package com.example.PostService.Repository;

import com.example.PostService.Model.Post;
import com.example.PostService.Model.RegistrovaniKorisnik;
import com.example.PostService.Model.Sadrzaj;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PostRepository extends JpaRepository<Post,Integer> {

    //Set<Post> findAllByRegistrovaniKorisnik(RegistrovaniKorisnik registraniKorisnik);

}
