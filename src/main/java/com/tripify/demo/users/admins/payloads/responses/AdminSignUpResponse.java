package com.tripify.demo.users.admins.payloads.responses;

import java.io.Serializable;

public class AdminSignUpResponse implements Serializable {
    String token;

    public AdminSignUpResponse() {
    }

    public AdminSignUpResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
