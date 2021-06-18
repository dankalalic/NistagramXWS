package com.example.PostService.Controller;

import com.example.PostService.DTO.StringDTO;
import com.example.PostService.Model.Lokacija;
import com.example.PostService.Model.Tagovi;
import com.example.PostService.Service.LokacijaService;
import com.example.PostService.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lokacije")
public class LokacijaController {
    private LokacijaService lokacijaService;

    @Autowired
    public LokacijaService setLokacijaService(LokacijaService lokacijaService) {
        return this.lokacijaService = lokacijaService;
    }

    @PostMapping("/findByNaziv")
    public ResponseEntity<Lokacija> findByNaziv(@RequestBody StringDTO stringDTO){
        return new ResponseEntity<>(lokacijaService.findByNaziv(stringDTO.getString()), HttpStatus.OK);
    }
}
