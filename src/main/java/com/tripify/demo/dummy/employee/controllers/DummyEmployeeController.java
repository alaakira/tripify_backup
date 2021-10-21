package com.tripify.demo.dummy.employee.controllers;

import com.tripify.demo.consts.Keys;
import com.tripify.demo.consts.URLs;
import com.tripify.demo.dummy.employee.payloads.EmployeeRequest;
import com.tripify.demo.dummy.employee.payloads.EmployeeResponse;
import com.tripify.demo.message_handler.ResponseBody;
import com.tripify.demo.privileges.model.Privilege;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping(URLs.DUMMY_PATH+URLs.EMPLOYEE_PATH)
public class DummyEmployeeController {

    @PostMapping()
    public ResponseBody<EmployeeResponse> addOffice(@RequestBody EmployeeRequest request,
                                                     HttpServletRequest httpServletRequest){
        if(validToken(httpServletRequest)){
        }
        EmployeeResponse response = new EmployeeResponse();
        response.id = 1L;
        response.firstName = request.firstName;
        response.lastName = request.lastName;
        response.phoneNum = request.phoneNum;
        response.department = "Office 1";
        response.companyName = "Company 1";
        response.roleName = "roleName 1";
        response.privileges = new ArrayList<>();
        Privilege privilege1 = new Privilege();privilege1.setId(1L);privilege1.setName("A");
        Privilege privilege2 = new Privilege();privilege2.setId(2L);privilege2.setName("B");
        response.privileges.add(privilege1);
        response.privileges.add(privilege2);
        return new ResponseBody<>(response);
    }

    @GetMapping
    public ResponseBody<ArrayList<EmployeeResponse>> getAllEmployees(HttpServletRequest httpServletRequest){
        if(validToken(httpServletRequest)){
        }
        EmployeeResponse response = new EmployeeResponse();
        response.id = 1L;
        response.firstName = "FNAME";
        response.lastName = "LNAME";
        response.phoneNum = "0933333333";
        response.department = "Office 1";
        response.companyName = "Company 1";
        response.roleName = "roleName 1";
        response.privileges = new ArrayList<>();
        Privilege privilege1 = new Privilege();privilege1.setId(1L);privilege1.setName("A");
        Privilege privilege2 = new Privilege();privilege2.setId(2L);privilege2.setName("B");
        response.privileges.add(privilege1);
        response.privileges.add(privilege2);
        EmployeeResponse response2 = new EmployeeResponse();
        response2.id = 2L;
        response.firstName = "FNAME2";
        response.lastName = "LNAME2";
        response.phoneNum = "0933333334";
        response2.department = "Office 2";
        response2.companyName = "Company 2";
        response2.roleName = "roleName 2";
        response2.privileges = new ArrayList<>();
        response2.privileges.add(privilege2);
        ArrayList<EmployeeResponse> responses = new ArrayList<>();
        responses.add(response);
        responses.add(response2);
        return new ResponseBody<>(responses);
    }

    public boolean validToken(HttpServletRequest request){
        String token = request.getHeader(Keys.AUTHORIZATION.getName());
        //TODO: add all cases
        return false;
    }

}
