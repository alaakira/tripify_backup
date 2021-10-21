package com.tripify.demo.users.clients.services;

import com.tripify.demo.users.clients.payloads.resquests.EmployeeSignUpRequest;
import com.tripify.demo.users.clients.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class EmployeeValidatorService {

    @Autowired
    private EmployeeRepository repository;

    public void isValidCreateOwnerRequest(@NonNull EmployeeSignUpRequest request){

    }

}
