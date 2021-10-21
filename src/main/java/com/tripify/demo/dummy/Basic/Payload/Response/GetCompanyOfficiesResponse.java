package com.tripify.demo.dummy.Basic.Payload.Response;

import com.tripify.demo.dummy.Models.Office;

import java.util.List;

public class GetCompanyOfficiesResponse {

    List<Office>offices ;

    public GetCompanyOfficiesResponse(List<Office> offices) {
        this.offices = offices;
    }

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }
}
