package com.example.CampaignService.controller;

import com.example.CampaignService.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/agenti")
public class AgentController {

    @Autowired
    private AgentService agentService;
}
