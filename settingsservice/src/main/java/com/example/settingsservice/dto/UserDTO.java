package com.example.settingsservice.dto;

public class UserDTO {
    private Integer id;
    private String username;
    private String lozinka;

    public UserDTO() {
    }

    public UserDTO(Integer id, String username, String lozinka) {
        this.id = id;
        this.username = username;
        this.lozinka = lozinka;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}
