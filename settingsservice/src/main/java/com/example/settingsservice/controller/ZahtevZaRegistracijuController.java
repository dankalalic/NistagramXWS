package com.example.settingsservice.controller;

import com.example.settingsservice.TokenUtils;
import com.example.settingsservice.model.IdOnlyDTO;
import com.example.settingsservice.model.StringDTO;
import com.example.settingsservice.model.ZahteviReturnDTO;
import com.example.settingsservice.model.regAgentDTO;
import com.example.settingsservice.service.ZahtevZaRegistracijuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/zahteviZaRegistraciju")
public class ZahtevZaRegistracijuController {

    @Autowired
    private ZahtevZaRegistracijuService zahtevZaRegistracijuService;

    @Autowired
    public TokenUtils tokenUtils;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/regAgent")
    public ResponseEntity<StringDTO> regAgent(@RequestBody regAgentDTO regAgentDTO, @RequestHeader(value="Authorization") String token) {
        Integer userId = tokenUtils.getIdFromToken(token);
        return new ResponseEntity<>( zahtevZaRegistracijuService.regAgent(regAgentDTO, userId), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getZahteve")
    public ResponseEntity<Set<ZahteviReturnDTO>> getZahteve(@RequestHeader(value="Authorization") String token) {
        Integer userId = tokenUtils.getIdFromToken(token);
        return new ResponseEntity<>( zahtevZaRegistracijuService.getZahteve(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/prihvati")
    public ResponseEntity<StringDTO> prihvati(@RequestBody IdOnlyDTO idOnlyDTO, @RequestHeader(value="Authorization") String token) {
        Integer userId = tokenUtils.getIdFromToken(token);
        return new ResponseEntity<>( zahtevZaRegistracijuService.prihvati(idOnlyDTO, userId), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/odbij")
    public ResponseEntity<StringDTO> odbij(@RequestBody IdOnlyDTO idOnlyDTO, @RequestHeader(value="Authorization") String token) {
        Integer userId = tokenUtils.getIdFromToken(token);
        return new ResponseEntity<>( zahtevZaRegistracijuService.odbij(idOnlyDTO, userId), HttpStatus.OK);
    }


}
