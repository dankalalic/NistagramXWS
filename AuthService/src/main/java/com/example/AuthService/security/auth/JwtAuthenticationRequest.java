package com.example.AuthService.security.auth;

//DTO za login (vrednosti unete na login strani)
public class JwtAuthenticationRequest {

    private String username;
    private String password;

    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String email, String lozinka) {
        this.setUsername(email);
        this.setPassword(lozinka);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
