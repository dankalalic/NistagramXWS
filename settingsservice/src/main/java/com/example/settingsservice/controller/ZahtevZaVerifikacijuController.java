package com.example.settingsservice.controller;

import com.example.settingsservice.TokenUtils;
import com.example.settingsservice.dto.ZahtevZaVerifikacijudto;
import com.example.settingsservice.model.*;
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

    @Autowired
    private TokenUtils tokenUtils;

    @GetMapping(value="/getAll")
    public ResponseEntity<List<ZahtevZaVerifikaciju>> getAll(@RequestHeader(value="Authorization") String token) throws Exception {
        //String role = tokenUtils.getRoleFromToken(token);
        //if (role.equals("admin")) {
            List<ZahtevZaVerifikaciju> zahtevZaVerifikacijuList = zahtevZaVerifikacijuRepository.getAllByObradjen(false);
            return new ResponseEntity<>(zahtevZaVerifikacijuList,HttpStatus.OK);
        //} else {
        //    throw new Exception("Zabranjeno");
        //}
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/createzahtev",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZahtevZaVerifikaciju> create(@RequestBody ZahtevZaVerifikacijudto zahtev, @RequestHeader(value="Authorization") String token) throws Exception {
        //String role = tokenUtils.getRoleFromToken(token);
       // if (role.equals("agent") || role.equals("user")) {
            ZahtevZaVerifikaciju zahtevZaVerifikaciju= new ZahtevZaVerifikaciju();
            zahtevZaVerifikaciju.setIme(zahtev.getIme());
            zahtevZaVerifikaciju.setPrezime(zahtev.getPrezime());
            zahtevZaVerifikaciju.setKategorija(zahtev.getKategorija());
            zahtevZaVerifikaciju.setSlika(zahtev.getSlika());
            zahtevZaVerifikacijuRepository.save(zahtevZaVerifikaciju);

            return new ResponseEntity<>(zahtevZaVerifikaciju,HttpStatus.OK);
        //} else {
        //    throw new Exception("Zabranjeno");
        //}
    }

    @PostMapping(value="/approve",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZahtevZaVerifikaciju> approve(@RequestBody IdVerDTO idVerificationDTO,@RequestHeader(value="Authorization") String token) throws Exception {
        //String role = tokenUtils.getRoleFromToken(token);
        //if (role.equals("admin")) {
            ZahtevZaVerifikaciju zahtevZaVerifikaciju=zahtevZaVerifikacijuRepository.findOneById(idVerificationDTO.getId());
            zahtevZaVerifikaciju.setObradjen(true);
            zahtevZaVerifikaciju.setStatus(true);
            return new ResponseEntity<>(zahtevZaVerifikacijuRepository.save(zahtevZaVerifikaciju),HttpStatus.OK);
        //} else {
        //    throw new Exception("Zabranjeno");
        //}
    }


    @PostMapping(value="/decline",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZahtevZaVerifikaciju> decline(@RequestBody IdVerDTO idVerificationDTO, @RequestHeader(value="Authorization") String token) throws Exception {
        //String role = tokenUtils.getRoleFromToken(token);
        //if (role.equals("admin")) {
            ZahtevZaVerifikaciju zahtevZaVerifikaciju=zahtevZaVerifikacijuRepository.findOneById(idVerificationDTO.getId());
            zahtevZaVerifikaciju.setObradjen(true);
            zahtevZaVerifikaciju.setStatus(false);
            return new ResponseEntity<>(zahtevZaVerifikacijuRepository.save(zahtevZaVerifikaciju),HttpStatus.OK);
        //} else {
        //    throw new Exception("Zabranjeno");
        //}
    }

}
