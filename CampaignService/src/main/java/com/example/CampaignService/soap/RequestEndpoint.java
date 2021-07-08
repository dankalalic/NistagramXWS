package com.example.CampaignService.soap;

import com.example.CampaignService.controller.AgentController;
import com.example.CampaignService.model.Agent;
import com.example.CampaignService.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class RequestEndpoint {

    private static final String NAMESPACE="http://localhost:8085/agenti/getAll";

    @Autowired
    private AgentController agentController;

    @PayloadRoot(namespace = NAMESPACE, localPart = "Agent")
    @ResponsePayload
    public List<Agent> getAll(@RequestPayload GetRequestsRequest getRequestsRequest){
        System.out.println("Soap request 1");
        return agentController.getAgenti(getRequestsRequest.token);
    }
}