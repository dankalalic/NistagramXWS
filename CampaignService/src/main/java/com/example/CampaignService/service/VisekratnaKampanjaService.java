package com.example.CampaignService.service;

import com.example.CampaignService.repository.VisekratnaKampanjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisekratnaKampanjaService {

    @Autowired
    private VisekratnaKampanjaRepository visekratnaKampanjaRepository;
}
