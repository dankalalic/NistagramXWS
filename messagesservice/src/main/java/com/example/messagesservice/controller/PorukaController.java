package com.example.messagesservice.controller;

import com.example.messagesservice.model.*;
import com.example.messagesservice.repository.PorukaRepository;
import com.example.messagesservice.repository.PostRepository;
import com.example.messagesservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/poruke")
public class PorukaController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PorukaRepository porukaRepository;
    @Autowired
    private PostRepository postRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/tekstualna")
    public ResponseEntity<Poruka> sendText(@RequestBody TekstualnaPorukaDTO tekstualnaPorukaDTO) {
        User posaljioac=userRepository.findOneById(tekstualnaPorukaDTO.getIdPosaljioca());
        User primalac= userRepository.findOneById(tekstualnaPorukaDTO.getIdPrimaoca());
        Poruka poruka= new Poruka();
        poruka.setTekst(tekstualnaPorukaDTO.getTekstPoruke());
        poruka.setUserPrima(primalac);
        poruka.setUserSalje(posaljioac);
        Poruka poruka1=porukaRepository.save(poruka);

        return new ResponseEntity<>(poruka1, HttpStatus.OK);



    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/post")
    public ResponseEntity<Poruka> sendPost(@RequestBody PostPorukaDTO postPorukaDTO) {
        User posaljioac=userRepository.findOneById(postPorukaDTO.getIdPosaljioca());
        User primalac= userRepository.findOneById(postPorukaDTO.getIdPrimaoca());
        Post post=postRepository.findOneById(postPorukaDTO.getIdPosta());
        Poruka poruka= new Poruka();
        poruka.setPost(post);
        poruka.setUserPrima(primalac);
        poruka.setUserSalje(posaljioac);
        Poruka poruka1=porukaRepository.save(poruka);

        return new ResponseEntity<>(poruka1, HttpStatus.OK);



    }
}
