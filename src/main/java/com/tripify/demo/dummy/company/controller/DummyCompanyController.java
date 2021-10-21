package com.tripify.demo.dummy.company.controller;

import com.tripify.demo.companies.models.Company;
import com.tripify.demo.companies.payloads.requests.CompanyRequest;
import com.tripify.demo.companies.payloads.responses.CompanyResponse;
import com.tripify.demo.consts.Keys;
import com.tripify.demo.consts.URLs;
import com.tripify.demo.message_handler.ResponseBody;
import com.tripify.demo.strings.RequestParamsNames;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping(URLs.DUMMY_PATH+URLs.COMPANY_PATH)
public class DummyCompanyController {

    @PostMapping()
    public ResponseBody<CompanyResponse> addCompany(@RequestParam(name = RequestParamsNames.images, required = false) MultipartFile logo,
                                                    @RequestParam(RequestParamsNames.details) String request
                                                    , HttpServletRequest httpServletRequest){
        if(validToken(httpServletRequest)){
        }
        Company company = new Company(new CompanyRequest(request));
        CompanyResponse response = new CompanyResponse(company);
        response.id = 1L;
//        if(logo != null && !logo.isEmpty())
//            response.logo = "logo/1/2";
        return new ResponseBody<>(response);
    }

    @GetMapping()
    public ResponseBody<ArrayList<CompanyResponse>> getAllCompanies(HttpServletRequest httpServletRequest) {
        if (validToken(httpServletRequest)) {
        }
        ArrayList<CompanyResponse> companyResponses = new ArrayList<>();
        Company company1 = new Company();
        Company company2 = new Company();
        company1.setId(1L);company1.setArName("اسم بالعربي");company1.setEnName("Company Name");company1.setAddress("address-dddd");company1.setEmail("email@email.com");company1.setPhone("0933333333");company1.setCertNum("123456");company1.setLandPhone("011-111111");company1.setLogoId(1L);
        company2.setId(2L);company2.setArName("اسم بالعربي 2");company2.setEnName("Company Name 2");company2.setAddress("address-dddd2");company2.setEmail("email2@email.com");company2.setPhone("0933333334");company2.setCertNum("789123");company2.setLandPhone("011-111112");company2.setLogoId(2L);
        companyResponses.add(new CompanyResponse(company1));
        companyResponses.add(new CompanyResponse(company2));
        return new ResponseBody<>(companyResponses);
    }

    public boolean validToken(HttpServletRequest request){
        String token = request.getHeader(Keys.AUTHORIZATION.getName());
        //TODO: add all cases
        return false;
    }

}
