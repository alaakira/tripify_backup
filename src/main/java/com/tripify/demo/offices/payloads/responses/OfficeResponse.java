package com.tripify.demo.offices.payloads.responses;

import com.tripify.demo.offices.models.Office;
import lombok.Data;

@Data
public class OfficeResponse {

    private Long id;

    private String name;

    private Double lng;

    private Double lat;

    private Long companyId;

    public OfficeResponse() {
    }

    public OfficeResponse(Office office) {
        this.id = office.getId();
        this.name = office.getName();
        this.lng = office.getLng();
        this.lat = office.getLat();
        this.companyId = office.getCompany().getId();
    }
}
