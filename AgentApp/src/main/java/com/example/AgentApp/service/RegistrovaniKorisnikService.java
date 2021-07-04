package com.example.AgentApp.service;

import com.example.AgentApp.repository.RegistrovaniKorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrovaniKorisnikService {

    private RegistrovaniKorisnikRepository registrovaniKorisnikRepository;

    @Autowired
    public void setRegistrovaniKorisnikRepository(RegistrovaniKorisnikRepository registrovaniKorisnikRepository) {
        this.registrovaniKorisnikRepository = registrovaniKorisnikRepository;
    }
}
