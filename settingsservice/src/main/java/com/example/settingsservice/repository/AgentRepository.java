package com.example.settingsservice.repository;

import com.example.settingsservice.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
    Agent findOneById(Integer id);
}
