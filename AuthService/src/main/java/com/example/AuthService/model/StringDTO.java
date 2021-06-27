package com.example.AuthService.model;

public class StringDTO {
    private String token;

    public StringDTO(String token) {
        this.token = token;
    }

    public StringDTO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
