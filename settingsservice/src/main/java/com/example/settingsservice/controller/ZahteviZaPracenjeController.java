package com.example.settingsservice.controller;

import com.example.settingsservice.model.RegisteredUser;
import com.example.settingsservice.model.ZahteviZaPracenje;
import com.example.settingsservice.model.idDTO;
import com.example.settingsservice.repository.RegisteredUserRepository;
import com.example.settingsservice.service.ZahteviZaPracenjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zahteviZaPracenje")
public class ZahteviZaPracenjeController {

    @Autowired
    private ZahteviZaPracenjeService zahteviZaPracenjeService;

    @Autowired
    private RegisteredUserRepository registeredUserRepository;

    @PostMapping(value="/primazahtev",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> followSomeone(@RequestBody idDTO idDTO) {
        RegisteredUser meuser= this.registeredUserRepository.findOneById(idDTO.getMyID());
        RegisteredUser someoneuser= this.registeredUserRepository.findOneById(idDTO.getSomeonesID());

        ZahteviZaPracenje zahteviZaPracenje= new ZahteviZaPracenje();
        zahteviZaPracenje.setSaljeZahtev(meuser);
        zahteviZaPracenje.setPrimaZahtev(someoneuser);

        zahteviZaPracenje=zahteviZaPracenjeService.save(zahteviZaPracenje);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping(value="/proba")
    public Boolean proba(@RequestBody idDTO idDTO) {

        String Hejj="hejj";


        return true;
    }

}
