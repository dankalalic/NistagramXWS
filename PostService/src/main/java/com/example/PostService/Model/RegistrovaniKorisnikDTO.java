package com.example.PostService.Model;

public class RegistrovaniKorisnikDTO {
    private Integer id;
    private String username;

    public RegistrovaniKorisnikDTO() {
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

    public RegistrovaniKorisnikDTO(Integer id, String username) {
        this.id = id;
        this.username = username;
    }
}
