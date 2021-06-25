package com.example.PostService.Model;

import java.util.Set;

public class SadrzajDTO {
    private Integer userId;
    private Set<Integer> slike;
    private String lokacija;

    public SadrzajDTO() {
    }

    public SadrzajDTO(Integer userId, Set<Integer> slike, String lokacija) {
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

    public Set<Integer> getSlike() {
        return slike;
    }

    public void setSlike(Set<Integer> slike) {
        this.slike = slike;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

}