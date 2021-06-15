package com.example.settingsservice.service;

import com.example.settingsservice.repository.ZahteviZaPracenjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZahteviZaPracenjeService {

    @Autowired
    private ZahteviZaPracenjeRepository zahteviZaPracenjeRepository;
}
