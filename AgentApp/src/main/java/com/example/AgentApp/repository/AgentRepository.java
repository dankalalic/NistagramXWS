package com.example.AgentApp.repository;

import com.example.AgentApp.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent,Integer> {

    Agent findOneById(Integer id);
}
