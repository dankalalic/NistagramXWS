package com.example.settingsservice.controller;

import com.example.settingsservice.dto.ZahtevZaVerifikacijudto;
import com.example.settingsservice.model.RegisteredUser;
import com.example.settingsservice.model.ZahtevZaVerifikaciju;
import com.example.settingsservice.model.idDTO;
import com.example.settingsservice.model.idVerificationDTO;
import com.example.settingsservice.repository.ZahtevZaVerifikacijuRepository;
import com.example.settingsservice.service.ZahtevZaRegistracijuService;
import com.example.settingsservice.service.ZahtevZaVerifikacijuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/zahteviZaVerifikaciju")
public class ZahtevZaVerifikacijuController {

    @Autowired
    private ZahtevZaVerifikacijuService zahtevZaVerifikacijuService;

    @Autowired
    private ZahtevZaVerifikacijuRepository zahtevZaVerifikacijuRepository;

    @GetMapping(value="/getAll",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ZahtevZaVerifikaciju>> getAll() {

        List<ZahtevZaVerifikaciju> zahtevZaVerifikacijuList = zahtevZaVerifikacijuRepository.getAllByObradjen(false);

        return new ResponseEntity<>(zahtevZaVerifikacijuList,HttpStatus.OK);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/createzahtev",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZahtevZaVerifikaciju> create(@RequestBody ZahtevZaVerifikacijudto zahtev) {
        ZahtevZaVerifikaciju zahtevZaVerifikaciju= new ZahtevZaVerifikaciju();
        zahtevZaVerifikaciju.setIme(zahtev.getIme());
        zahtevZaVerifikaciju.setPrezime(zahtev.getPrezime());
        zahtevZaVerifikaciju.setKategorija(zahtev.getKategorija());
        zahtevZaVerifikaciju.setSlika(zahtev.getSlika());
        zahtevZaVerifikacijuRepository.save(zahtevZaVerifikaciju);



        return new ResponseEntity<>(zahtevZaVerifikaciju,HttpStatus.OK);

    }

    @PostMapping(value="/approve",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZahtevZaVerifikaciju> approve(idVerificationDTO idVerificationDTO) {

        ZahtevZaVerifikaciju zahtevZaVerifikaciju=zahtevZaVerifikacijuRepository.findOneById(idVerificationDTO.getId());
        zahtevZaVerifikaciju.setObradjen(true);
        zahtevZaVerifikaciju.setStatus(true);
        return new ResponseEntity<>(zahtevZaVerifikaciju,HttpStatus.OK);

    }


    @PostMapping(value="/decline",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZahtevZaVerifikaciju> decline(idVerificationDTO idVerificationDTO) {

        ZahtevZaVerifikaciju zahtevZaVerifikaciju=zahtevZaVerifikacijuRepository.findOneById(idVerificationDTO.getId());
        zahtevZaVerifikaciju.setObradjen(true);
        zahtevZaVerifikaciju.setStatus(false);
        return new ResponseEntity<>(zahtevZaVerifikaciju,HttpStatus.OK);

    }






}
