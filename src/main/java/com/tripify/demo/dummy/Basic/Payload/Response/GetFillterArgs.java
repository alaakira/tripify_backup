package com.tripify.demo.dummy.Basic.Payload.Response;

import com.tripify.demo.dummy.Models.City;
import com.tripify.demo.dummy.Models.Company;

import java.util.List;

public class GetFillterArgs {


    List<Company>companies;
    List<City>cities;

    public GetFillterArgs(List<Company> companies, List<City> cities) {
        this.companies = companies;
        this.cities = cities;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
