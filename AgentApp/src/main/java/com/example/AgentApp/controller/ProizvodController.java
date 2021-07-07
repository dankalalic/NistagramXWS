package com.example.AgentApp.controller;

import com.example.AgentApp.TokenUtils;
import com.example.AgentApp.dto.IdDTO;
import com.example.AgentApp.dto.PorudzbinaDTO;
import com.example.AgentApp.dto.ProizvodDto;
import com.example.AgentApp.model.*;
import com.example.AgentApp.repository.*;
import com.example.AgentApp.service.KorpaService;
import com.example.AgentApp.service.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/proizvod")
public class ProizvodController {

    private ProizvodService proizvodService;

    private ProizvodRepository proizvodRepository;

    private ProdavnicaRepository prodavnicaRepository;

    private KorpaService korpaService;

    private RegistrovaniKorisnikRepository registrovaniKorisnikRepository;

    private KorpaRepository korpaRepository;
    @Autowired
    public void setProdavnicaRepository(ProdavnicaRepository prodavnicaRepository) {
        this.prodavnicaRepository = prodavnicaRepository;
    }

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

    @Autowired
    public SlikaRepository slikaRepository;

    @PostMapping(value="/createproizvod",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proizvod> create(@RequestBody ProizvodDto proizvodDto,@RequestHeader(value="Authorization") String token) {
        Integer userId = tokenUtils.getIdFromToken(token);
        Proizvod proizvod=proizvodService.create(proizvodDto);
        Agent agent =agentRepository.findOneById(userId);
        Prodavnica prodavnica=agent.getProdavnica();
        proizvod.setProdavnica(prodavnica);
        proizvod.setAgent(agent);
        proizvod.setNaziv(proizvodDto.getNaziv());


        Slika slika = slikaRepository.findOneById(proizvodDto.getSlika());
        proizvod.setSlika(slika);
        proizvod = proizvodRepository.save(proizvod);
        slika.setProizvod(proizvod);
        slikaRepository.save(slika);
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

    @PostMapping(value="/dobaviproizvode",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Proizvod>> dobaviproizvode(@RequestBody IdDTO idDTO) {

        Prodavnica prodavnica=prodavnicaRepository.findOneById(idDTO.getId());
        return new ResponseEntity<>(prodavnica.getProizvodi(), HttpStatus.OK);
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
        Korpa korpa=new Korpa();
        korpa.setRegistrovaniKorisnik(registrovaniKorisnik);
        Set<Proizvod> proizvodi=new HashSet<>();
        proizvodi.add(proizvod);
        korpa.setProizvodi(proizvodi);
        korpaRepository.save(korpa);
        registrovaniKorisnik.setKorpa(korpa);
        registrovaniKorisnikRepository.save(registrovaniKorisnik);





        return new ResponseEntity<>(korpa, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/upload")
    public Integer uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {

        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        Slika slika= new Slika(file.getOriginalFilename(),file.getBytes(),file.getSize());

        this.slikaRepository.save(slika);

        return slika.getId();
    }

    @GetMapping(value="/getByAgent")
    public List<Proizvod> getByAgent(@RequestHeader(value="Authorization") String token) {
        Integer userId = tokenUtils.getIdFromToken(token);
        return proizvodService.findByAgent(userId);
    }
}
