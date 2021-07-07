package com.example.AgentApp.service;

import com.example.AgentApp.repository.ProdavnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdavnicaService {

    private ProdavnicaRepository prodavnicaRepository;

    @Autowired
    public void setProdavnicaRepository(ProdavnicaRepository prodavnicaRepository) {
        this.prodavnicaRepository = prodavnicaRepository;
    }
}
