package com.example.AgentApp.repository;

import com.example.AgentApp.model.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProizvodRepository extends JpaRepository<Proizvod,Integer> {
    Proizvod findOneById(Integer id);
}
