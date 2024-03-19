package com.example.ecommerceweb.DTO;

public class AutheticationResponse {
    private String token;

    public AutheticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
