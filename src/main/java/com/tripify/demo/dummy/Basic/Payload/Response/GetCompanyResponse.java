package com.tripify.demo.dummy.Basic.Payload.Response;

import com.tripify.demo.dummy.Models.Company;

public class GetCompanyResponse {

    Company company ;


    public GetCompanyResponse(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
