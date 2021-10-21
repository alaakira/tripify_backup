package com.tripify.demo.dummy.Basic.Payload.Response;

import com.tripify.demo.dummy.Models.City;

import java.util.List;

public class GetCitiesResponse {

    List<City>cities;

    public GetCitiesResponse(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
