package com.pcatalog.productcatalog.models;

import java.io.Serializable;

public class TokenDto implements Serializable {
    private String token;

    protected TokenDto() {
    }

    public TokenDto(String token) {
        setToken(token);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
