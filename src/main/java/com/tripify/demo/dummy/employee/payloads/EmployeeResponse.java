package com.tripify.demo.dummy.employee.payloads;

import com.tripify.demo.company_roles.payloads.responses.CompanyRoleResponse;
import com.tripify.demo.privileges.model.Privilege;
import com.tripify.demo.users.clients.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeResponse {
    public Long id;
    public String firstName;
    public String lastName;
    public String phoneNum;
    public String department;
    public String companyName;
    public String roleName;
    public CompanyRoleResponse role;
    public ArrayList<Privilege> privileges;

    public EmployeeResponse(Employee employee) {
        if(employee.getId() != null)
            id = employee.getId();
        firstName = employee.getUserId().getFirstName();
        lastName = employee.getUserId().getLastName();
        phoneNum = employee.getUserId().getPhone();
        role = new CompanyRoleResponse(employee.getRoleId());
        roleName = role.name;
        companyName = employee.getRoleId().getCompany().getEnName();
    }

    public EmployeeResponse() {
    }
}
