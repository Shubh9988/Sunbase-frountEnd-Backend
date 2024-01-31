package com.geekster.customermanagement.dto;

public class UserLoginDto {

    private String Email;
    private String password;

    public UserLoginDto() {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLoginDto(String email, String password) {
        Email = email;
        this.password = password;
    }
}
