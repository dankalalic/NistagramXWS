package com.example.CampaignService.service;

import com.example.CampaignService.model.Kampanja;
import com.example.CampaignService.repository.KampanjaRepository;
import com.example.CampaignService.repository.ReklamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KampanjaService {

    @Autowired
    private KampanjaRepository kampanjaRepository;

}
