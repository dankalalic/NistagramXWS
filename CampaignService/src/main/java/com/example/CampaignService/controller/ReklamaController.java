package com.example.CampaignService.controller;

import com.example.CampaignService.service.ReklamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/reklame")
public class ReklamaController {

    @Autowired
    private ReklamaService reklamaService;
}
