package com.example.CampaignService.service;

import com.example.CampaignService.repository.JednokratnaKampanjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JednokratnaKampanjaService {

    @Autowired
    private JednokratnaKampanjaRepository jednokratnaKampanjaRepository;
}
