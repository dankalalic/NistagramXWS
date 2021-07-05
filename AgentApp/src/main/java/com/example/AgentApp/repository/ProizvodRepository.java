package com.example.AgentApp.repository;

import com.example.AgentApp.model.Agent;
import com.example.AgentApp.model.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProizvodRepository extends JpaRepository<Proizvod,Integer> {
    Proizvod findOneById(Integer id);

    List<Proizvod> findByAgent(Agent agent);
}
