package com.example.messagesservice.model;

public class TekstualnaPorukaDTO {
    private Integer idPosaljioca;
    private Integer idPrimaoca;
    private String tekstPoruke;

    public TekstualnaPorukaDTO() {
    }

    public TekstualnaPorukaDTO(Integer idPosaljioca, Integer idPrimaoca, String tekstPoruke) {
        this.idPosaljioca = idPosaljioca;
        this.idPrimaoca = idPrimaoca;
        this.tekstPoruke = tekstPoruke;
    }

    public Integer getIdPosaljioca() {
        return idPosaljioca;
    }

    public void setIdPosaljioca(Integer idPosaljioca) {
        this.idPosaljioca = idPosaljioca;
    }

    public Integer getIdPrimaoca() {
        return idPrimaoca;
    }

    public void setIdPrimaoca(Integer idPrimaoca) {
        this.idPrimaoca = idPrimaoca;
    }

    public String getTekstPoruke() {
        return tekstPoruke;
    }

    public void setTekstPoruke(String tekstPoruke) {
        this.tekstPoruke = tekstPoruke;
    }
}
