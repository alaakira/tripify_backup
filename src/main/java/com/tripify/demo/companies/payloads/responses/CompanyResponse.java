package com.tripify.demo.companies.payloads.responses;

import com.tripify.demo.companies.models.Company;
import com.tripify.demo.dummy.employee.payloads.EmployeeResponse;
import com.tripify.demo.files.payloads.responses.UploadFileResponse;

public class CompanyResponse {

    public Long id;

    public String arName;

    public String enName;

    public String address;

    public String email;

    public String phone;

    public String landPhone;

    public String certNum;

    public EmployeeResponse owner;

    public UploadFileResponse logo;

    public CompanyResponse(Company newCompany) {
        this.id = newCompany.getId();
        this.arName = newCompany.getArName();
        this.enName = newCompany.getEnName();
        this.address = newCompany.getAddress();
        this.email = newCompany.getEmail();
        this.phone = newCompany.getPhone();
        this.landPhone = newCompany.getLandPhone();
        this.certNum = newCompany.getCertNum();
    }
}
