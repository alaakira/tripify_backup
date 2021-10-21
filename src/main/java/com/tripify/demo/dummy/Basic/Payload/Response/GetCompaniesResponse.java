package com.tripify.demo.dummy.Basic.Payload.Response;

import com.tripify.demo.dummy.Models.Company;

import java.util.List;

public class GetCompaniesResponse {

    List<Company>companies;

    public GetCompaniesResponse(List<Company> companies) {
        this.companies = companies;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
