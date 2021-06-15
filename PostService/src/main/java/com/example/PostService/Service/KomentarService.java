package com.example.PostService.Service;

import com.example.PostService.Model.Komentar;
import com.example.PostService.Repository.KomentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KomentarService {
    
    private KomentarRepository komentarRepository;
    
    @Autowired
    public KomentarRepository setKomentarRepository(KomentarRepository komentarRepository) {
        return this.komentarRepository = komentarRepository;
    }
}
