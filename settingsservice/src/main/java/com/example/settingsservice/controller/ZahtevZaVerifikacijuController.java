package com.example.settingsservice.controller;

import com.example.settingsservice.service.ZahtevZaRegistracijuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zahteviZaVerifikaciju")
public class ZahtevZaVerifikacijuController {

    @Autowired
    private ZahtevZaRegistracijuService zahtevZaRegistracijuService;
}
