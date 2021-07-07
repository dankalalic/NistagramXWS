package com.example.CampaignService.repository;

import com.example.CampaignService.model.Agent;
import com.example.CampaignService.model.JednokratnaKampanja;
import com.example.CampaignService.model.VisekratnaKampanja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisekratnaKampanjaRepository extends JpaRepository<VisekratnaKampanja, Integer>{

    List<VisekratnaKampanja> getAllByAgent(Agent agent);
}
