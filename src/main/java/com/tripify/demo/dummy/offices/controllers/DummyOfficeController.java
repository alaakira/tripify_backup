package com.tripify.demo.dummy.offices.controllers;


import com.tripify.demo.consts.Keys;
import com.tripify.demo.consts.URLs;
import com.tripify.demo.dummy.employee.payloads.EmployeeRequest;
import com.tripify.demo.dummy.employee.payloads.EmployeeResponse;
import com.tripify.demo.dummy.offices.payloads.OfficeRequest;
import com.tripify.demo.dummy.offices.payloads.OfficeResponse;
import com.tripify.demo.message_handler.ResponseBody;
import com.tripify.demo.privileges.model.Privilege;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping(URLs.DUMMY_PATH+URLs.OFFICE_PATH)
public class DummyOfficeController {

    @PostMapping()
    public ResponseBody<OfficeResponse> addOffice(@RequestBody OfficeRequest request,
                                                  HttpServletRequest httpServletRequest){
        if(validToken(httpServletRequest)){
        }
        OfficeResponse response = new OfficeResponse();
        response.id = 1L;
        response.name = request.name;
        response.lng = request.lng;
        response.lat = request.lat;
        response.companyId = request.companyId;
        response.companyName = "Company Name";
        return new ResponseBody<>(response);
    }

    @GetMapping()
    public ResponseBody<ArrayList<OfficeResponse>> getAllOffices(HttpServletRequest httpServletRequest){
        if(validToken(httpServletRequest)){
        }

        OfficeResponse response = new OfficeResponse();
        OfficeResponse response2 = new OfficeResponse();
        response.id = 1L;response.name = "O1";response.lng = 37.11;response.lat = 38.11;response.companyId = 1L;response.companyName = "Company Name 1";
        response2.id = 2L;response2.name = "O2";response2.lng = 37.22;response2.lat = 38.22;response2.companyId = 2L;response2.companyName = "Company Name 2";
        ArrayList<OfficeResponse> responses = new ArrayList<>();responses.add(response);responses.add(response2);
        return new ResponseBody<>(responses);
    }


    public boolean validToken(HttpServletRequest request){
        String token = request.getHeader(Keys.AUTHORIZATION.getName());
        //TODO: add all cases
        return false;
    }
}
