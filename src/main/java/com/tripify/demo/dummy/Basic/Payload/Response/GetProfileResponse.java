package com.tripify.demo.dummy.Basic.Payload.Response;

import com.tripify.demo.dummy.Models.User;

public class GetProfileResponse {

    User profile ;

    public GetProfileResponse(User profile) {
        this.profile = profile;
    }

    public User getProfile() {
        return profile;
    }

    public void setProfile(User profile) {
        this.profile = profile;
    }
}
