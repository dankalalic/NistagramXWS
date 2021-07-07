package com.example.PostService.Model;

import java.util.List;
import java.util.Set;

public class ReklamaReturnDTO {
    private Set<Slika> slike;
    private Integer brojLajkova;
    private Integer brojDislajkova;

    public ReklamaReturnDTO(Set<Slika> slike, Integer brojLajkova, Integer brojDislajkova) {
        this.slike = slike;
        this.brojLajkova = brojLajkova;
        this.brojDislajkova = brojDislajkova;
    }

    public ReklamaReturnDTO() {
    }

    public Set<Slika> getSlike() {
        return slike;
    }

    public void setSlike(Set<Slika> slike) {
        this.slike = slike;
    }

    public Integer getBrojLajkova() {
        return brojLajkova;
    }

    public void setBrojLajkova(Integer brojLajkova) {
        this.brojLajkova = brojLajkova;
    }

    public Integer getBrojDislajkova() {
        return brojDislajkova;
    }

    public void setBrojDislajkova(Integer brojDislajkova) {
        this.brojDislajkova = brojDislajkova;
    }
}
