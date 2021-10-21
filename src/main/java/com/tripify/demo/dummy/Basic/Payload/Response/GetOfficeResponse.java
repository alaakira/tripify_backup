package com.tripify.demo.dummy.Basic.Payload.Response;

import com.tripify.demo.dummy.Models.Office;

public class GetOfficeResponse {
    Office office ;


    public GetOfficeResponse(Office office) {
        this.office = office;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
