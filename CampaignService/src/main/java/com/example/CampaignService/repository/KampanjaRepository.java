package com.example.CampaignService.repository;

import com.example.CampaignService.model.Agent;
import com.example.CampaignService.model.JednokratnaKampanja;
import com.example.CampaignService.model.Kampanja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KampanjaRepository extends JpaRepository<Kampanja, Integer> {

    List<Kampanja> getAllByAgent(Agent agent);
}
