package com.tripify.demo.offices.payloads.requests;

public class OfficeRequest {

    public Long id;

    public String name;

    public Double lng;

    public Double lat;

    public Long companyId;

    @Override
    public String toString() {
        return "OfficeRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", companyId=" + companyId +
                '}';
    }
}
