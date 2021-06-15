package com.example.AuthService.model;

public class UserTokenRoleDto {

    private String accessToken;
    private int expiresIn;
    private Boolean enabled;

    public UserTokenRoleDto(String accessToken, int expiresIn, Boolean enabled) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.enabled=enabled;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

}
