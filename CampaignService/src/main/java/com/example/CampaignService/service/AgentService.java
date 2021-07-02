package com.example.CampaignService.service;

import com.example.CampaignService.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;
}
