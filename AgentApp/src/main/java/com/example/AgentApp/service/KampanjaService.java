package com.example.AgentApp.service;

import com.example.AgentApp.repository.KampanjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KampanjaService {

    private KampanjaRepository kampanjaRepository;

    @Autowired
    public void setKampanjaRepository(KampanjaRepository kampanjaRepository) {
        this.kampanjaRepository = kampanjaRepository;
    }
}
