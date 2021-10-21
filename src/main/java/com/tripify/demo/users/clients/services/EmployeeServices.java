package com.tripify.demo.users.clients.services;

import com.tripify.demo.company_roles.repositories.CompanyRolesRepository;
import com.tripify.demo.exceptions.NotFoundRuntimeException;
import com.tripify.demo.users.clients.model.Employee;
import com.tripify.demo.users.clients.model.User;
import com.tripify.demo.users.clients.payloads.resquests.EmployeeSignUpRequest;
import com.tripify.demo.users.clients.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserServices userServices;

    @Autowired
    CompanyRolesRepository companyRolesRepository;

    public Employee createEmployee(EmployeeSignUpRequest request){
        User user = userServices.createUser(request);
        Employee employee = new Employee(user);
        Employee result = employeeRepository.save(employee);
        user.setUserId(result.getId());
        userServices.linkId(user);
        return result;
    }

    public Employee getEmployeeById(Long ownerId) {
        return employeeRepository.findById(ownerId).orElseThrow(NotFoundRuntimeException::new);
    }
}
