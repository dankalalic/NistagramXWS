package com.example.CampaignService.service;

import com.example.CampaignService.model.Agent;
import com.example.CampaignService.model.JednokratnaKampanja;
import com.example.CampaignService.model.Kampanja;
import com.example.CampaignService.repository.JednokratnaKampanjaRepository;
import com.example.CampaignService.repository.KampanjaRepository;
import com.example.CampaignService.repository.ReklamaRepository;
import com.example.CampaignService.repository.VisekratnaKampanjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KampanjaService {

    @Autowired
    private KampanjaRepository kampanjaRepository;

}
