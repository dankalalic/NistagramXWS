package com.example.AgentApp.service;

import com.example.AgentApp.repository.NarudzbinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NarudzbinaService {

    private NarudzbinaRepository narudzbinaRepository;

    @Autowired
    public void setNarudzbinaRepository(NarudzbinaRepository narudzbinaRepository) {
        this.narudzbinaRepository = narudzbinaRepository;
    }
}
