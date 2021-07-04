package com.example.AgentApp.repository;

import com.example.AgentApp.model.Kampanja;
import com.example.AgentApp.model.Prodavnica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdavnicaRepository extends JpaRepository<Prodavnica,Integer> {
}
