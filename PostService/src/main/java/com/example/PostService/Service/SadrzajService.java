package com.example.PostService.Service;

import com.example.PostService.Model.Post;
import com.example.PostService.Model.RegistrovaniKorisnik;
import com.example.PostService.Model.Sadrzaj;
import com.example.PostService.Repository.SadrzajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SadrzajService {
    private SadrzajRepository sadrzajRepository;

    @Autowired
    public void setSadrzajRepository(SadrzajRepository sadrzajRepository) {
        this.sadrzajRepository = sadrzajRepository;
    }

    public Set<Sadrzaj> findallsadrzajbyregistrovanikorisnik(RegistrovaniKorisnik registrovanikorisnik){
        return sadrzajRepository.findAllByRegistrovaniKorisnik(registrovanikorisnik);
    }


}
