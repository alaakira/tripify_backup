package com.tripify.demo.companies.payloads.requests;

import lombok.Data;

@Data
public class EditCompanyRequest {

    Long id;

    String arName;

    String enName;

    String address;

    String email;

    String phone;

    String landPhone;

}
