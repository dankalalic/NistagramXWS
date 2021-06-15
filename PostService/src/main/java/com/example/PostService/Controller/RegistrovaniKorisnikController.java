package com.example.PostService.Controller;

import com.example.PostService.Service.RegistrovaniKorisnikService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/registrovanikorisnik")
public class RegistrovaniKorisnikController {
    private RegistrovaniKorisnikService registrovaniKorisnikService;

    @Autowired
    public void setRegistrovaniKorisnikService(RegistrovaniKorisnikService registrovaniKorisnikService) {
        this.registrovaniKorisnikService = registrovaniKorisnikService;
    }







}
