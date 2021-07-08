package com.example.CampaignService.controller;

import com.example.CampaignService.TokenUtils;
import com.example.CampaignService.model.Agent;
import com.example.CampaignService.repository.AgentRepository;
import com.example.CampaignService.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/agenti")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private TokenUtils tokenUtils;

    @GetMapping("/getAll")
    public List<Agent> getAgenti(@RequestHeader(value = "Authorization") String token) {
        Integer id = tokenUtils.getIdFromToken(token);
        return agentRepository.findAll();
    }
}
