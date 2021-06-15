package com.example.followerservice.model.DTO;

public class UserDTO {

   private Integer myID;

   private Integer someonesID;

    public UserDTO() {
    }

    public UserDTO(Integer myID, Integer someonesID) {
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
