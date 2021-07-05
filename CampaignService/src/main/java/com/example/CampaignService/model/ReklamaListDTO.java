package com.example.CampaignService.model;

import java.util.ArrayList;
import java.util.List;

public class ReklamaListDTO {

    private List<ReklamaDTO> reklamaDTOS = new ArrayList<>();
    private Integer agentId;

    public ReklamaListDTO() {
    }

    public ReklamaListDTO(List<ReklamaDTO> reklamaDTOS, Integer agentId) {
        this.reklamaDTOS = reklamaDTOS;
        this.agentId = agentId;
    }

    public List<ReklamaDTO> getReklamaDTOS() {
        return reklamaDTOS;
    }

    public void setReklamaDTOS(List<ReklamaDTO> reklamaDTOS) {
        this.reklamaDTOS = reklamaDTOS;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }
}
