package com.example.AuthService.model;

public class UserRequest {

    private Integer id;

    private String email;

    private String password;

    /*private String firstname;

    private String lastname;*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
