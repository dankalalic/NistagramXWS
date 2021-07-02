package com.example.CampaignService.controller;

import com.example.CampaignService.service.VisekratnaKampanjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/visekratneKampanja")
public class VisekratnaKampanjaController {

    @Autowired
    private VisekratnaKampanjaService visekratnaKampanjaService;
}
