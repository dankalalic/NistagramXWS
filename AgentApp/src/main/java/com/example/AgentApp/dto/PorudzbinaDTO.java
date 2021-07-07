package com.example.AgentApp.dto;

public class PorudzbinaDTO {
    private Integer id;
    private Integer kolicinazaporudzbinu;

    public PorudzbinaDTO(Integer id, Integer kolicinazaporudzbinu) {
        this.id = id;
        this.kolicinazaporudzbinu = kolicinazaporudzbinu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKolicinazaporudzbinu() {
        return kolicinazaporudzbinu;
    }

    public void setKolicinazaporudzbinu(Integer kolicinazaporudzbinu) {
        this.kolicinazaporudzbinu = kolicinazaporudzbinu;
    }

    public PorudzbinaDTO() {
    }
}
