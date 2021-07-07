package com.example.AuthService.model;

public class TargetGroupDTO {


    private Integer id;
    private Integer pocetak;
    private Integer kraj;

    public TargetGroupDTO() {
    }

    public TargetGroupDTO(Integer id, Integer pocetak, Integer kraj) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPocetak() {
        return pocetak;
    }

    public void setPocetak(Integer pocetak) {
        this.pocetak = pocetak;
    }

    public Integer getKraj() {
        return kraj;
    }

    public void setKraj(Integer kraj) {
        this.kraj = kraj;
    }
}
