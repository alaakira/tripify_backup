package com.tripify.demo.companies.payloads.requests;

import com.google.gson.Gson;
import com.tripify.demo.users.clients.payloads.resquests.EmployeeSignUpRequest;
import lombok.Data;

@Data
public class CompanyRequest {

    Long id;

    String arName;

    String enName;

    String address;

    String email;

    String phone;

    String landPhone;

    String certNum;

    EmployeeSignUpRequest owner;

    public CompanyRequest() {
    }

    public CompanyRequest(String stringRequest) {
        CompanyRequest request = new Gson().fromJson(stringRequest, CompanyRequest.class);
        id = request.getId();
        arName = request.getArName();
        enName = request.getEnName();
        address = request.getAddress();
        email = request.getEmail();
        phone = request.getPhone();
        landPhone = request.getLandPhone();
        certNum = request.getCertNum();
    }

}
