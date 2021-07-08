package com.example.PostService.Repository;

import com.example.PostService.Model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
    Agent findOneById(Integer id);

    Agent findByUsername(String username);
}
