package com.example.settingsservice.model;

public class regAgentDTO {

    public String email;
    public String websajt;

    public regAgentDTO() {
    }

    public regAgentDTO(String email, String websajt) {
        this.email = email;
        this.websajt = websajt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsajt() {
        return websajt;
    }

    public void setWebsajt(String websajt) {
        this.websajt = websajt;
    }
}
