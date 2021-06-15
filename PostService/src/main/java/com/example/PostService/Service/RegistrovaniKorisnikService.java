package com.example.PostService.Service;

import com.example.PostService.Model.RegistrovaniKorisnik;
import com.example.PostService.Repository.RegistrovaniKorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrovaniKorisnikService {

    private RegistrovaniKorisnikRepository registrovaniKorisnikRepository;

    @Autowired
    public void setRegistrovaniKorisnikRepository(RegistrovaniKorisnikRepository registrovaniKorisnikRepository) {
        this.registrovaniKorisnikRepository = registrovaniKorisnikRepository;
    }
    public RegistrovaniKorisnik findonebyid(Integer id){return registrovaniKorisnikRepository.findOneById(id);}
}
