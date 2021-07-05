package com.example.AgentApp.repository;

import com.example.AgentApp.model.RegistrovaniKorisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrovaniKorisnikRepository extends JpaRepository<RegistrovaniKorisnik,Integer> {
    RegistrovaniKorisnik findOneById(Integer userId);
}
