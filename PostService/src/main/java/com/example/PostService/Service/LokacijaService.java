package com.example.PostService.Service;

import com.example.PostService.Model.Lokacija;
import com.example.PostService.Model.Tagovi;
import com.example.PostService.Repository.LokacijaRepository;
import com.example.PostService.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LokacijaService {
    private LokacijaRepository lokacijaRepository;

    @Autowired
    public LokacijaRepository setLokacijaRepository(LokacijaRepository lokacijaRepository)
    {
        return this.lokacijaRepository = lokacijaRepository;
    }

    public Lokacija findByNaziv(String naziv) {
        return this.lokacijaRepository.findByNaziv(naziv);
    }
}