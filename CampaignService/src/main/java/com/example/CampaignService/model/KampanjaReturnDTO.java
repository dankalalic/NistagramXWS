package com.example.CampaignService.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class KampanjaReturnDTO {
    private List<ReklamaReturnDTO> reklame;
    private CiljnaGrupa ciljnaGrupa;
    private LocalDateTime pocetakPrikazivanja;
    private LocalDateTime krajPrikazivanja;
    private Date pocetakPrikazivanja1;
    private Date krajPrikazivanja1;
    private Integer potrebanBrojPrikazivanja;
    private Integer lajkovali;
    private Integer dislajkovali;

    public KampanjaReturnDTO(List<ReklamaReturnDTO> reklame) {
        this.reklame = reklame;
    }

    public KampanjaReturnDTO(List<ReklamaReturnDTO> reklame, CiljnaGrupa ciljnaGrupa, LocalDateTime pocetakPrikazivanja, LocalDateTime krajPrikazivanja, Date pocetakPrikazivanja1, Date krajPrikazivanja1, Integer potrebanBrojPrikazivanja) {
        this.reklame = reklame;
        this.ciljnaGrupa = ciljnaGrupa;
        this.pocetakPrikazivanja = pocetakPrikazivanja;
        this.krajPrikazivanja = krajPrikazivanja;
        this.pocetakPrikazivanja1 = pocetakPrikazivanja1;
        this.krajPrikazivanja1 = krajPrikazivanja1;
        this.potrebanBrojPrikazivanja = potrebanBrojPrikazivanja;
    }

    public KampanjaReturnDTO() {
    }

    public List<ReklamaReturnDTO> getReklame() {
        return reklame;
    }

    public void setReklame(List<ReklamaReturnDTO> reklame) {
        this.reklame = reklame;
    }

    public CiljnaGrupa getCiljnaGrupa() {
        return ciljnaGrupa;
    }

    public void setCiljnaGrupa(CiljnaGrupa ciljnaGrupa) {
        this.ciljnaGrupa = ciljnaGrupa;
    }

    public LocalDateTime getPocetakPrikazivanja() {
        return pocetakPrikazivanja;
    }

    public void setPocetakPrikazivanja(LocalDateTime pocetakPrikazivanja) {
        this.pocetakPrikazivanja = pocetakPrikazivanja;
    }

    public LocalDateTime getKrajPrikazivanja() {
        return krajPrikazivanja;
    }

    public void setKrajPrikazivanja(LocalDateTime krajPrikazivanja) {
        this.krajPrikazivanja = krajPrikazivanja;
    }

    public Date getPocetakPrikazivanja1() {
        return pocetakPrikazivanja1;
    }

    public void setPocetakPrikazivanja1(Date pocetakPrikazivanja1) {
        this.pocetakPrikazivanja1 = pocetakPrikazivanja1;
    }

    public Date getKrajPrikazivanja1() {
        return krajPrikazivanja1;
    }

    public void setKrajPrikazivanja1(Date krajPrikazivanja1) {
        this.krajPrikazivanja1 = krajPrikazivanja1;
    }

    public Integer getPotrebanBrojPrikazivanja() {
        return potrebanBrojPrikazivanja;
    }

    public void setPotrebanBrojPrikazivanja(Integer potrebanBrojPrikazivanja) {
        this.potrebanBrojPrikazivanja = potrebanBrojPrikazivanja;
    }

    public Integer getLajkovali() {
        return lajkovali;
    }

    public void setLajkovali(Integer lajkovali) {
        this.lajkovali = lajkovali;
    }

    public Integer getDislajkovali() {
        return dislajkovali;
    }

    public void setDislajkovali(Integer dislajkovali) {
        this.dislajkovali = dislajkovali;
    }
}
