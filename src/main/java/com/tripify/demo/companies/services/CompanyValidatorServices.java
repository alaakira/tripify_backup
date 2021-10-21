package com.tripify.demo.companies.services;

import com.tripify.demo.companies.models.Company;
import com.tripify.demo.companies.payloads.requests.CompanyRequest;
import com.tripify.demo.companies.payloads.requests.EditCompanyRequest;
import com.tripify.demo.companies.repository.CompanyRepository;
import com.tripify.demo.exceptions.AlreadyExistsException;
import com.tripify.demo.exceptions.NotFoundRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyValidatorServices {

    @Autowired
    private CompanyRepository repository;

    void isValidCreateCompanyRequest(CompanyRequest request){
        if(repository.findByPhone(request.getPhone()).isPresent())
            throw new AlreadyExistsException("Phone number");
        if(repository.findByLandPhone(request.getLandPhone()).isPresent())
            throw new AlreadyExistsException("Land phone number");
        if(repository.findByCertNum(request.getCertNum()).isPresent())
            throw new AlreadyExistsException("Certificate number");
        if(request.getOwner() == null)
            throw new NotFoundRuntimeException("No owner assigned");
    }

    void isValidUpdateCompanyRequest(EditCompanyRequest request){
        if(request.getPhone() == null)
            throw new NotFoundRuntimeException("Phone number");
        if(repository.findByPhone(request.getPhone()).isPresent() &&
            !repository.findByPhone(request.getPhone()).get().getId().equals(request.getId()))
            throw new AlreadyExistsException("Phone number");
        if(request.getLandPhone() == null)
            throw new NotFoundRuntimeException("Land-phone number");
        if(repository.findByLandPhone(request.getLandPhone()).isPresent() &&
                !repository.findByLandPhone(request.getLandPhone()).get().getId().equals(request.getId()))
            throw new AlreadyExistsException("Land-phone number");
        if(request.getEmail() == null)
            throw new NotFoundRuntimeException("Email");
        if(repository.findByEmail(request.getEmail()).isPresent() &&
                !repository.findByEmail(request.getEmail()).get().getId().equals(request.getId()))
            throw new AlreadyExistsException("Email");
    }

}
