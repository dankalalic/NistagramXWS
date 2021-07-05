package com.example.CampaignService.controller;

import com.example.CampaignService.TokenUtils;
import com.example.CampaignService.model.JednokratnaDTO;
import com.example.CampaignService.model.JednokratnaKampanja;
import com.example.CampaignService.service.JednokratnaKampanjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/jednokratneKampanje")
public class JednokratnaKampanjaController {

    @Autowired
    private JednokratnaKampanjaService jednokratnaKampanjaService;

    @Autowired
    private TokenUtils tokenUtils;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/create")
    public JednokratnaKampanja create(@RequestBody JednokratnaDTO jednokratnaDTO, @RequestHeader(value="Authorization") String token) {
        Integer userId = tokenUtils.getIdFromToken(token);
        return jednokratnaKampanjaService.saveKampanja(jednokratnaDTO, userId);
    }
}
