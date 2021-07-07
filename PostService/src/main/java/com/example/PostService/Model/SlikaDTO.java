package com.example.PostService.Model;

import javax.persistence.Column;
import javax.persistence.Lob;

public class SlikaDTO {

    private Integer id;


    private String name;


    private byte[] url;

    private Long size;

    public SlikaDTO() {
    }

    public SlikaDTO(Integer id, String name, byte[] url, Long size) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getUrl() {
        return url;
    }

    public void setUrl(byte[] url) {
        this.url = url;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
