package com.example.CampaignService.repository;

import com.example.CampaignService.model.Agent;
import com.example.CampaignService.model.JednokratnaDTO;
import com.example.CampaignService.model.JednokratnaKampanja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JednokratnaKampanjaRepository extends JpaRepository<JednokratnaKampanja, Integer> {

    List<JednokratnaKampanja> getAllByAgent(Agent agent);

    JednokratnaKampanja findOneById(Integer id);
}
