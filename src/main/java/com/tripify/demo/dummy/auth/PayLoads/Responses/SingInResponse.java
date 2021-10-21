package com.tripify.demo.dummy.auth.PayLoads.Responses;

public class SingInResponse {

    private String token;

    public SingInResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
