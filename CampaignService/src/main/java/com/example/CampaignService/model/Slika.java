package com.example.CampaignService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


public class Slika {

    private String name;

    @Lob
    private byte[] url;

    private Long size;

    public Slika(String name, byte[] url, Long size) {
        this.name = name;
        this.url = url;
        this.size = size;
    }
    public Slika() {
    }
    public byte[] getUrl() {
        return url;
    }

    public void setUrl(byte[] url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
