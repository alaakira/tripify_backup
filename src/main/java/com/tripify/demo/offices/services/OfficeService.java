package com.tripify.demo.offices.services;

import com.tripify.demo.companies.models.Company;
import com.tripify.demo.companies.repository.CompanyRepository;
import com.tripify.demo.exceptions.*;
import com.tripify.demo.offices.models.Office;
import com.tripify.demo.offices.payloads.requests.OfficeRequest;
import com.tripify.demo.offices.payloads.responses.OfficeResponse;
import com.tripify.demo.offices.repositories.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficeService {

    @Autowired
    private OfficeRepository repository;

    @Autowired
    private CompanyRepository companyRepository;

    public OfficeResponse addOffice(OfficeRequest request){
        List<Office> allOffices = repository.findAll();
        List<Office> sameLocation = allOffices.stream().filter(it ->
                (it.getLat().equals(request.lat) && it.getLng().equals(request.lng)
                )).collect(Collectors.toList());
        return saveOffice(request, sameLocation);
    }

    public OfficeResponse editOffice(OfficeRequest request){
        if(request.id == null)
            throw new NoIdException();
        List<Office> allOffices = repository.findAll();
        List<Office> sameLocation = allOffices.stream().filter(it ->
                (it.getLat().equals(request.lat) && it.getLng().equals(request.lng) && !it.getId().equals(request.id)
                )).collect(Collectors.toList());
        return saveOffice(request, sameLocation);
    }

    private OfficeResponse saveOffice(OfficeRequest request, List<Office> sameLocation) {
        if(sameLocation.size() > 0)
            throw new AlreadyExistRuntimeException("Location already reserved");
        if(request.companyId == null)
            throw new NotFoundRuntimeException("Company Id is null");
        Company company = companyRepository.findById(request.companyId).orElseThrow(() -> new NotFoundRuntimeException("Company not found"));
        Office office = repository.save(new Office(request, company));
        return new OfficeResponse(office);
    }

    public OfficeResponse getOfficeById(Long id){
        if(id != null){
            Office result = repository.findById(id).orElseThrow(() -> new NotFoundRuntimeException("Office not found"));
            return new OfficeResponse(result);
        }else{
            throw new NoIdException();
        }
    }

    public List<OfficeResponse> getOfficeByCompanyId(Long id){
        if(id != null){
            List<Office> results = repository.getOfficesByCompanyId(id)
                    .orElseThrow(() -> new NotFoundRuntimeException("Company not found"));
            ArrayList<OfficeResponse> responses = new ArrayList<>();
            results.forEach( item -> responses.add(new OfficeResponse(item)));
            return responses;
        }else{
            throw new InvalidDataException();
        }
    }

    public OfficeResponse deleteOfficeById(Long id){
        if(id != null){
            Office office = repository.findById(id).orElseThrow(() -> new NotFoundRuntimeException("Office not found"));
            repository.deleteById(id);
            return new OfficeResponse(office);
        }else{
            throw new InvalidDataException();
        }
    }

}
