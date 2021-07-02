package com.example.CampaignService.controller;

import com.example.CampaignService.service.KampanjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/kampanje")
public class KampanjaController {

    @Autowired
    private KampanjaService kampanjaService;
}
