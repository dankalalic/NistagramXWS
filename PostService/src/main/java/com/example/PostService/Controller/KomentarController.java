package com.example.PostService.Controller;

import com.example.PostService.Model.Komentar;
import com.example.PostService.Repository.KomentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/komentari")
public class KomentarController {

    @Autowired
    private KomentarRepository komentarRepository;

    @Autowired
    public void setKomentarRepository(KomentarRepository komentarRepository) {
        this.komentarRepository = komentarRepository;
    }

    @GetMapping
    public  ResponseEntity<List<Komentar>> getMedications(){
        

        List<Komentar> nesto= komentarRepository.findAll();
        return new ResponseEntity<>(nesto, HttpStatus.OK);
    }
}
