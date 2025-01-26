package com.ansh.restSpring.dto;



public class UserSignupDTO {


    private String username;


    private String password;

    public UserSignupDTO() {
    }

    public UserSignupDTO(String username, String password) {
        this.username = username;
        this.password = password;
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
