package com.example.AgentApp.controller;


import com.example.AgentApp.TokenUtils;
import com.example.AgentApp.model.Agent;
import com.example.AgentApp.repository.AgentRepository;
import com.example.AgentApp.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/agent")
public class AgentController {

    private AgentService agentService;

    @Autowired
    public void setAgentService(AgentService agentService) {
        this.agentService = agentService;
    }

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
