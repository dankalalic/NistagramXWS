package com.example.settingsservice.service;

import com.example.settingsservice.repository.KategorijaProfilaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KategorijaProfilaService {

    @Autowired
    private KategorijaProfilaRepository kategorijaProfilaRepository;
}
