package com.tripify.demo.companies.controllers;

import com.tripify.demo.companies.payloads.requests.CompanyRequest;
import com.tripify.demo.companies.payloads.requests.EditCompanyRequest;
import com.tripify.demo.companies.payloads.responses.CompanyResponse;
import com.tripify.demo.companies.privileges.CompanyPrivileges;
import com.tripify.demo.companies.services.CompanyServices;
import com.tripify.demo.consts.URLs;
import com.tripify.demo.message_handler.ResponseBody;
import com.tripify.demo.strings.RequestParamsNames;
import com.tripify.demo.users.clients.payloads.resquests.EmployeeSignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping(URLs.COMPANY_PATH)
public class CompanyController {
    @Autowired
    CompanyServices services;

    @Autowired
    CompanyPrivileges companyPrivileges;

    @PostMapping(value = URLs.SIGN_UP_URL)
    @PreAuthorize("hasAnyAuthority(T(com.tripify.demo.companies.privileges.CompanyPrivileges).CREATE_COMPANY," +
            "T(com.tripify.demo.companies.privileges.CompanyPrivileges).MANAGE_COMPANIES)")
    public ResponseBody<CompanyResponse> createCompany(@RequestParam(name = RequestParamsNames.images, required = false) MultipartFile logo,
                                                       @RequestPart(name = RequestParamsNames.details) CompanyRequest request){
        CompanyResponse result = services.createCompany(request,logo);
        return new ResponseBody<>(result);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority(T(com.tripify.demo.companies.privileges.CompanyPrivileges).VIEW_COMPANY," +
            "T(com.tripify.demo.companies.privileges.CompanyPrivileges).MANAGE_COMPANIES)")
    public ResponseBody<List<CompanyResponse>> getAllCompanies(){
        return new ResponseBody<>(services.getAllCompanies());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority(T(com.tripify.demo.companies.privileges.CompanyPrivileges).VIEW_COMPANY," +
            "T(com.tripify.demo.companies.privileges.CompanyPrivileges).MANAGE_COMPANIES)")
    public ResponseBody<CompanyResponse> getCompanyById(@PathVariable("id") Long id){
        CompanyResponse result = services.getCompanyById(id);
        return new ResponseBody<>(result);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority(T(com.tripify.demo.companies.privileges.CompanyPrivileges).EDIT_COMPANY," +
            "T(com.tripify.demo.companies.privileges.CompanyPrivileges).MANAGE_COMPANIES)")
    public ResponseBody<CompanyResponse> editCompany(@RequestParam(name = RequestParamsNames.images, required = false) MultipartFile logo,
                                                     @RequestPart(RequestParamsNames.details) EditCompanyRequest request){
        CompanyResponse result = services.editCompany(request,logo);
        return new ResponseBody<>(result);
    }
}
