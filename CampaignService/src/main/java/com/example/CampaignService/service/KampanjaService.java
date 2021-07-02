package com.example.CampaignService.service;

import com.example.CampaignService.repository.KampanjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KampanjaService {

    @Autowired
    private KampanjaRepository kampanjaRepository;
}
