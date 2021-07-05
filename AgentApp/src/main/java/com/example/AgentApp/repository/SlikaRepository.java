package com.example.AgentApp.repository;

import com.example.AgentApp.model.Slika;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlikaRepository extends JpaRepository<Slika, Integer> {

    Slika findOneById(Integer id);
}
