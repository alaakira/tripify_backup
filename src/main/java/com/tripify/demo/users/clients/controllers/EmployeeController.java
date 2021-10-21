package com.tripify.demo.users.clients.controllers;


import com.tripify.demo.consts.URLs;
import com.tripify.demo.message_handler.ResponseBody;
import com.tripify.demo.users.clients.model.Employee;
import com.tripify.demo.users.clients.services.EmployeeServices;
import com.tripify.demo.users.clients.payloads.resquests.EmployeeSignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(URLs.CLIENT_AUTH+URLs.EMPLOYEE_PATH)
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @PostMapping(URLs.SIGN_UP_URL)
    public ResponseBody<Employee> createEmployee(@RequestBody EmployeeSignUpRequest request){
        Employee result = employeeServices.createEmployee(request);
        return new ResponseBody<>(result);
    }
}
