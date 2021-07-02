package com.example.settingsservice.model;

public class IdOnlyDTO {

    private Integer id;

    public IdOnlyDTO(Integer id) {
        this.id = id;
    }

    public IdOnlyDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
