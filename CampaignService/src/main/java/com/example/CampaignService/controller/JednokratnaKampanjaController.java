package com.example.CampaignService.controller;

import com.example.CampaignService.model.JednokratnaKampanja;
import com.example.CampaignService.service.JednokratnaKampanjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/jednokratneKampanje")
public class JednokratnaKampanjaController {

    @Autowired
    private JednokratnaKampanjaService jednokratnaKampanjaService;
}
