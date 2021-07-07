package com.example.CampaignService.repository;

import com.example.CampaignService.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Integer> {

    Agent findOneById(Integer id);
}
