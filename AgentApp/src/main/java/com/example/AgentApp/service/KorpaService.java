package com.example.AgentApp.service;

import com.example.AgentApp.repository.KorpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorpaService {
            private KorpaRepository korpaRepository;
            @Autowired
            public void setKorpaRepository(KorpaRepository korpaRepository) {
                this.korpaRepository = korpaRepository;
            }
}
