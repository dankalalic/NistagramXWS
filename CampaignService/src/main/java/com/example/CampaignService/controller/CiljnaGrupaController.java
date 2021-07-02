package com.example.CampaignService.controller;

import com.example.CampaignService.service.CiljnaGrupaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ciljneGrupe")
public class CiljnaGrupaController {

    @Autowired
    private CiljnaGrupaService ciljnaGrupaService;
}
