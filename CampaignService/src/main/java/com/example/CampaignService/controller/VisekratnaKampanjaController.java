package com.example.CampaignService.controller;

import com.example.CampaignService.TokenUtils;
import com.example.CampaignService.model.JednokratnaDTO;
import com.example.CampaignService.model.JednokratnaKampanja;
import com.example.CampaignService.model.VisekratnaDTO;
import com.example.CampaignService.model.VisekratnaKampanja;
import com.example.CampaignService.repository.AgentRepository;
import com.example.CampaignService.service.VisekratnaKampanjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/visekratneKampanja")
public class VisekratnaKampanjaController {

    @Autowired
    private VisekratnaKampanjaService visekratnaKampanjaService;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AgentRepository agentRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/create")
    public VisekratnaKampanja create(@RequestBody VisekratnaDTO visekratnaDTO, @RequestHeader(value="Authorization") String token) {
        Integer userId = tokenUtils.getIdFromToken(token);
        return visekratnaKampanjaService.saveKampanja(visekratnaDTO, userId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/getAll")
    public List<VisekratnaKampanja> getAll(@RequestHeader(value="Authorization") String token) {
        Integer userId = tokenUtils.getIdFromToken(token);
        return visekratnaKampanjaService.getAllByAgent(agentRepository.findOneById(userId));
    }
}
