package com.example.settingsservice.service;

import com.example.settingsservice.repository.ZahtevZaRegistracijuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZahtevZaRegistracijuService {

    @Autowired
    private ZahtevZaRegistracijuRepository zahtevZaRegistracijuRepository;
}
