package com.example.CampaignService.model;

import java.util.Set;

public class SadrzajjDTO {

    private Integer id;
    private Set<SlikaDTO> slike;



    public SadrzajjDTO() {
    }

    public SadrzajjDTO(Integer userId, Set<SlikaDTO> slike) {
        this.id = userId;
        this.slike = slike;

    }



    public Set<SlikaDTO> getSlike() {
        return slike;
    }

    public void setSlike(Set<SlikaDTO> slike) {
        this.slike = slike;
    }
}
