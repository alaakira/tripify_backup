package com.tripify.demo.dummy.auth.PayLoads.Responses;

public class UserPhoneCheckSingUpResponse {

    Boolean success;
    public String message;

    public UserPhoneCheckSingUpResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
