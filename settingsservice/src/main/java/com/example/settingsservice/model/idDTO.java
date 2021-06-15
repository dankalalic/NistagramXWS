package com.example.settingsservice.model;

public class idDTO {
    private Integer myID;

    private Integer someonesID;

    public idDTO() {
    }

    public idDTO(Integer myID, Integer someonesID) {
        this.myID = myID;
        this.someonesID = someonesID;
    }

    public Integer getMyID() {
        return myID;
    }

    public void setMyID(Integer myID) {
        this.myID = myID;
    }

    public Integer getSomeonesID() {
        return someonesID;
    }

    public void setSomeonesID(Integer someonesID) {
        this.someonesID = someonesID;
    }
}
