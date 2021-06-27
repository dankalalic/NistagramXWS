package com.example.PostService.Repository;

import com.example.PostService.Model.RegistrovaniKorisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrovaniKorisnikRepository extends JpaRepository<RegistrovaniKorisnik,Integer> {

    RegistrovaniKorisnik findOneById(Integer id);

    RegistrovaniKorisnik findOneByUsername(String username);
}
