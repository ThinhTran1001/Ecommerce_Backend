package com.example.ecommerceweb.DTO;

import java.io.Serializable;

public class AutheticationResponse implements Serializable {
    private String token;

    public AutheticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
