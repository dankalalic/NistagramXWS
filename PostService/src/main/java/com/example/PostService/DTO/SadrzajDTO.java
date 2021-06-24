package com.example.PostService.dto;


import java.util.List;
import java.util.Set;

public class SadrzajDTO {
    private Integer userId;
    private Set<String> slike;
    private String lokacija;

    public SadrzajDTO() {
    }

    public SadrzajDTO(Integer userId, Set<String> slike, String lokacija) {
        this.userId = userId;
        this.slike = slike;
        this.lokacija = lokacija;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Set<String> getSlike() {
        return slike;
    }

    public void setSlike(Set<String> slike) {
        this.slike = slike;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }
}
