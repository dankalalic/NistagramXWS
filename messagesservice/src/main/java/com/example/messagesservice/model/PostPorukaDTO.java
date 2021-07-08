package com.example.messagesservice.model;

public class PostPorukaDTO {
    private Integer idPosaljioca;
    private Integer idPrimaoca;
    private Integer idPosta;

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

    public Integer getIdPosta() {
        return idPosta;
    }

    public void setIdPosta(Integer idPosta) {
        this.idPosta = idPosta;
    }

    public PostPorukaDTO() {
    }

    public PostPorukaDTO(Integer idPosaljioca, Integer idPrimaoca, Integer idPosta) {
        this.idPosaljioca = idPosaljioca;
        this.idPrimaoca = idPrimaoca;
        this.idPosta = idPosta;
    }
}
