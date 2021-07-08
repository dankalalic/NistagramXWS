package com.example.CampaignService.controller;

import com.example.CampaignService.model.Agent;
import com.example.CampaignService.model.IdDTO;
import com.example.CampaignService.repository.AgentRepository;
import com.example.CampaignService.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/agenti")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @Autowired
    private AgentRepository agentRepository;



}
