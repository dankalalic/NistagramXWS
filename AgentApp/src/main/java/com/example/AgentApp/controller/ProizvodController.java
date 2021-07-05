package com.example.AgentApp.controller;

import com.example.AgentApp.TokenUtils;
import com.example.AgentApp.dto.IdDTO;
import com.example.AgentApp.dto.PorudzbinaDTO;
import com.example.AgentApp.dto.ProizvodDto;
import com.example.AgentApp.model.*;
import com.example.AgentApp.repository.AgentRepository;
import com.example.AgentApp.repository.KorpaRepository;
import com.example.AgentApp.repository.ProizvodRepository;
import com.example.AgentApp.repository.RegistrovaniKorisnikRepository;
import com.example.AgentApp.service.KorpaService;
import com.example.AgentApp.service.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/proizvod")
public class ProizvodController {

    private ProizvodService proizvodService;

    private ProizvodRepository proizvodRepository;

    private KorpaService korpaService;

    private RegistrovaniKorisnikRepository registrovaniKorisnikRepository;

    private KorpaRepository korpaRepository;

    @Autowired
    public void setKorpaRepository(KorpaRepository korpaRepository) {
        this.korpaRepository = korpaRepository;
    }

    @Autowired
    public void setRegistrovaniKorisnikRepository(RegistrovaniKorisnikRepository registrovaniKorisnikRepository) {
        this.registrovaniKorisnikRepository = registrovaniKorisnikRepository;
    }

    @Autowired
    public void setKorpaService(KorpaService korpaService) {
        this.korpaService = korpaService;
    }

    @Autowired
    public void setProizvodRepository(ProizvodRepository proizvodRepository) {
        this.proizvodRepository = proizvodRepository;
    }

    private AgentRepository agentRepository;

    @Autowired
    public void setAgentRepository(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @Autowired
    public TokenUtils tokenUtils;

    @Autowired
    public void setProizvodService(ProizvodService proizvodService) {
        this.proizvodService = proizvodService;
    }

    @PostMapping(value="/createproizvod",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proizvod> create(@RequestBody ProizvodDto proizvodDto,@RequestHeader(value="Authorization") String token) {
        Integer userId = tokenUtils.getIdFromToken(token);
        Proizvod proizvod=proizvodService.create(proizvodDto);
        Agent agent =agentRepository.findOneById(userId);
        Prodavnica prodavnica=agent.getProdavnica();
        proizvod.setProdavnica(prodavnica);
        proizvod.setAgent(agent);
        proizvodRepository.save(proizvod);



        return new ResponseEntity<>(proizvod, HttpStatus.OK);
    }


    @PostMapping(value="/izmeniproizvod",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proizvod> izmena(@RequestBody ProizvodDto proizvodDto) {


        Proizvod proizvod=proizvodService.IzmenaProizvoda(proizvodDto);


        return new ResponseEntity<>(proizvod, HttpStatus.OK);
    }

    @PostMapping(value="/izbrisiproizvod",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proizvod> izbaciproizvod(@RequestBody IdDTO idDTO) {


        Proizvod proizvod=proizvodService.findById(idDTO.getId());
        proizvodRepository.delete(proizvod);


        return new ResponseEntity<>(proizvod, HttpStatus.OK);
    }

    @PostMapping(value="/dodajukorpu",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korpa> ubaciukorpu(@RequestBody PorudzbinaDTO idDTO, @RequestHeader(value="Authorization") String token) throws Exception {

        Proizvod proizvod=proizvodService.findById(idDTO.getId());

        if(proizvod.getRaspolozivoStanje()-idDTO.getKolicinazaporudzbinu()<0){
            throw new Exception("prozivoda nema na stanju");
        }
        else {

            proizvod.setRaspolozivoStanje(proizvod.getRaspolozivoStanje()- idDTO.getKolicinazaporudzbinu());
        }
        proizvod.setKolicinazaporudzbinu(idDTO.getKolicinazaporudzbinu());
        Integer userId = tokenUtils.getIdFromToken(token);
        RegistrovaniKorisnik registrovaniKorisnik=registrovaniKorisnikRepository.findOneById(userId);
        Korpa korpa=registrovaniKorisnik.getKorpa();
        Set<Proizvod> proizvodi=new HashSet<>();
        proizvodi.add(proizvod);
        korpa.setProizvodi(proizvodi);
        korpaRepository.save(korpa);



        return new ResponseEntity<>(korpa, HttpStatus.OK);
    }

}
