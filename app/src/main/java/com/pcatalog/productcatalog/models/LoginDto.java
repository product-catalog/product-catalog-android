package com.pcatalog.productcatalog.models;

import java.io.Serializable;

public class LoginDto implements Serializable {
    private String username;
    private String password;

    protected LoginDto() {
    }

    public LoginDto(String username, String password) {
        setUsername(username);
        setPassword(password);
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
