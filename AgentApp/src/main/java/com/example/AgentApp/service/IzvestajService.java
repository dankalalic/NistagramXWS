package com.example.AgentApp.service;

import com.example.AgentApp.repository.IzvestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IzvestajService {
    private IzvestajRepository izvestajRepository;

    @Autowired
    public void setIzvestajRepository(IzvestajRepository izvestajRepository) {
        this.izvestajRepository = izvestajRepository;
    }
}
