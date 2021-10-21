package com.tripify.demo.company_roles.services;

import com.tripify.demo.companies.models.Company;
import com.tripify.demo.companies.repository.CompanyRepository;
import com.tripify.demo.company_roles.model.CompanyRoles;
import com.tripify.demo.company_roles.payloads.requests.CompanyRoleRequest;
import com.tripify.demo.company_roles.payloads.responses.CompanyRoleResponse;
import com.tripify.demo.company_roles.repositories.CompanyRolesRepository;
import com.tripify.demo.exceptions.IdNotFoundException;
import com.tripify.demo.exceptions.NoIdException;
import com.tripify.demo.exceptions.NotFoundRuntimeException;
import com.tripify.demo.privileges.model.Privilege;
import com.tripify.demo.privileges.repositories.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyRolesService {

    @Autowired
    private CompanyRolesRepository repository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    public CompanyRoleResponse createRole(CompanyRoleRequest request){
        if(request.companyId == null)
            throw new NoIdException();
        return saveRole(request);
    }

    public CompanyRoleResponse updateRole(CompanyRoleRequest request){
        if(request.companyId == null || request.id == null)
            throw new NoIdException();
        return saveRole(request);
    }

    private CompanyRoleResponse saveRole(CompanyRoleRequest request) {
        if(request.privilegesIds.isEmpty())
            throw new RuntimeException("No Privileges are found");
        Company company = companyRepository.findById(request.companyId).orElseThrow(() -> new NotFoundRuntimeException("Company not found"));
        CompanyRoles companyRoles = new CompanyRoles(request, company);
        List<Privilege> privileges = new ArrayList<>();
        request.privilegesIds.forEach(privilegeId ->{
            Privilege privilege = privilegeRepository.findById(privilegeId).orElseThrow(IdNotFoundException::new);
            privileges.add(privilege);
        });
        companyRoles.setPrivileges(privileges);
        System.out.println("Privileges: "+privilegeRepository.findAll());
        companyRepository.findAll().forEach(company1 -> System.out.println(company1.getId()));
        CompanyRoles result = repository.save(companyRoles);
        return new CompanyRoleResponse(result);
    }

    public CompanyRoleResponse getRoleById(Long id){
        if(id == null)
            throw new NoIdException();
        CompanyRoles result = repository.findById(id).orElseThrow(IdNotFoundException::new);
        return new CompanyRoleResponse(result);
    }

    public ArrayList<CompanyRoleResponse> getRoleByCompanyId(Long id){
        if(id == null)
            throw new NoIdException();
        List<CompanyRoles> result = repository.findByCompany_Id(id).orElseThrow(IdNotFoundException::new);
        ArrayList<CompanyRoleResponse> results = new ArrayList<>();
        result.forEach(model -> results.add(new CompanyRoleResponse(model)));
        return results;
    }

    public CompanyRoleResponse deleteCompanyRole(Long id){
        if(id == null)
            throw new NoIdException();
        CompanyRoles result = repository.findById(id).orElseThrow(IdNotFoundException::new);
        repository.deleteById(id);
        return new CompanyRoleResponse(result);
    }

}
