package com.tripify.demo.dummy.auth.PayLoads.Responses;

public class SingupResponse {

    public String token;


    public SingupResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
