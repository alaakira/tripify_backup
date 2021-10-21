package com.tripify.demo.companies.services;

import com.tripify.demo.companies.models.Company;
import com.tripify.demo.companies.payloads.requests.CompanyRequest;
import com.tripify.demo.companies.payloads.requests.EditCompanyRequest;
import com.tripify.demo.companies.payloads.responses.CompanyResponse;
import com.tripify.demo.companies.repository.CompanyRepository;
import com.tripify.demo.company_roles.payloads.requests.CompanyRoleRequest;
import com.tripify.demo.company_roles.payloads.responses.CompanyRoleResponse;
import com.tripify.demo.company_roles.services.CompanyRolesService;
import com.tripify.demo.dummy.employee.payloads.EmployeeResponse;
import com.tripify.demo.exceptions.NotFoundRuntimeException;
import com.tripify.demo.files.model.DBFile;
import com.tripify.demo.files.payloads.responses.UploadFileResponse;
import com.tripify.demo.files.services.FileServices;
import com.tripify.demo.files.services.FilesValidatorService;
import com.tripify.demo.privileges.model.Privilege;
import com.tripify.demo.roles.types.RoleTypesComponent;
import com.tripify.demo.users.clients.model.Employee;
import com.tripify.demo.users.clients.services.EmployeeServices;
import com.tripify.demo.users.clients.services.EmployeeValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServices {

    @Autowired
    CompanyRepository repository;

    @Autowired
    CompanyValidatorServices validatorServices;

    @Autowired
    EmployeeValidatorService employeeValidatorService;

    @Autowired
    EmployeeServices employeeServices;

    @Autowired
    FilesValidatorService filesValidatorService;

    @Autowired
    FileServices fileServices;

    @Autowired
    CompanyRolesService companyRolesService;


    @Transactional
    public CompanyResponse createCompany(CompanyRequest request, MultipartFile logo) {
        validateCreateCompanyRequest(logo, request);
        DBFile savedLogo = saveLogoIfExists(logo);
        Company company = saveCompany(request, savedLogo);
        CompanyRoleResponse roleResponse = saveOwnerCompanyRole(company.getId());
        request.getOwner().roleId = roleResponse.id;
        Employee employee = saveOwner(request);
        company.setOwnerId(employee.getId());
        repository.save(company);
        EmployeeResponse employeeResponse = new EmployeeResponse(employee);
        CompanyResponse response = new CompanyResponse(company);
        response.owner = employeeResponse;
        if (savedLogo != null)
            response.logo = new UploadFileResponse(savedLogo);
        return response;
    }

    private void validateCreateCompanyRequest(MultipartFile logo, CompanyRequest companyRequest) {
        validatorServices.isValidCreateCompanyRequest(companyRequest);
        employeeValidatorService.isValidCreateOwnerRequest(companyRequest.getOwner());
        filesValidatorService.isValidNewFile(logo);
    }

    private Employee saveOwner(CompanyRequest companyRequest) {
        return employeeServices.createEmployee(companyRequest.getOwner());
    }

    private DBFile saveLogoIfExists(MultipartFile logo) {
        if (logo == null || logo.isEmpty())
            return null;
        return fileServices.storeFile(logo);
    }

    private Company saveCompany(CompanyRequest companyRequest, @Nullable DBFile logo) {
        Company company = new Company(companyRequest);
        if (logo != null)
            company.setLogoId(logo.getId());
        return repository.save(company);
    }

    private CompanyRoleResponse saveOwnerCompanyRole(Long companyId) {
        CompanyRoleRequest request = new CompanyRoleRequest();
        request.name = "Owner";
        request.companyId = companyId;
        List<Privilege> privileges = RoleTypesComponent.getOwnerPrivilegesIds();
        request.privilegesIds = new ArrayList<>();
        privileges.forEach(privilege -> request.privilegesIds.add(privilege.getId()));
        return companyRolesService.createRole(request);
    }

    public List<CompanyResponse> getAllCompanies() {
        List<Company> companyList = repository.findAll();
        List<CompanyResponse> responseList = new ArrayList<>();
        companyList.forEach(company -> {
                    CompanyResponse response = buildCompanyResponseAfterFetching(company);
                    responseList.add(response);
                }
        );
        return responseList;
    }

    public CompanyResponse getCompanyById(Long id) {
        Company company = repository.findById(id).orElseThrow(() -> new NotFoundRuntimeException("Company not found"));
        return buildCompanyResponseAfterFetching(company);
    }

    private CompanyResponse buildCompanyResponseAfterFetching(Company company) {
        CompanyResponse response = new CompanyResponse(company);
        Employee owner = employeeServices.getEmployeeById(company.getOwnerId());
        response.owner = new EmployeeResponse(owner);
        if (company.getLogoId() != null) {
            DBFile logo = fileServices.getFile(company.getLogoId());
            response.logo = new UploadFileResponse(logo);
        }
        return response;
    }

    @Transactional
    public CompanyResponse editCompany(EditCompanyRequest request, MultipartFile logo) {
        validateUpdateCompanyRequest(logo, request);
        Company company = repository.findById(request.getId()).orElseThrow(() -> new NotFoundRuntimeException("Company not found"));
        DBFile savedLogo = null;
        if ((logo == null || logo.isEmpty()) && company.getLogoId() != null)
            fileServices.deleteFile(company.getLogoId());
        if (logo != null && !logo.isEmpty() && company.getLogoId() != null)
            savedLogo = fileServices.update(company.getLogoId(), logo);
        if (logo != null && !logo.isEmpty() && company.getLogoId() == null)
            savedLogo = fileServices.storeFile(logo);
        if (savedLogo != null)
            company.setLogoId(savedLogo.getId());
        company.update(request);
        company = repository.save(company);
        Employee employee = employeeServices.getEmployeeById(company.getOwnerId());
        EmployeeResponse employeeResponse = new EmployeeResponse(employee);
        CompanyResponse response = new CompanyResponse(company);
        response.owner = employeeResponse;
        if (savedLogo != null)
            response.logo = new UploadFileResponse(savedLogo);
        return response;
    }

    public void validateUpdateCompanyRequest(MultipartFile logo, EditCompanyRequest request) {
        if (request.getId() == null || repository.findById(request.getId()).isEmpty())
            throw new NotFoundRuntimeException("Company not found");
        validatorServices.isValidUpdateCompanyRequest(request);
        if (logo != null && !logo.isEmpty())
            filesValidatorService.isValidNewFile(logo);
    }

}
