package com.example.demo.dao;

public class AuthTokenDAO {

    private String token;

    public AuthTokenDAO() {
    }

    public AuthTokenDAO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
