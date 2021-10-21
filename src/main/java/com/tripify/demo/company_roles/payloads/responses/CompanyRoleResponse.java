package com.tripify.demo.company_roles.payloads.responses;

import com.tripify.demo.company_roles.model.CompanyRoles;
import com.tripify.demo.privileges.model.Privilege;
import com.tripify.demo.privileges.payloads.responses.PrivilegeResponse;

import java.util.ArrayList;
import java.util.List;

public class CompanyRoleResponse {

    public Long id;

    public String name;

    public Long companyId;

    public String companyName;

    public List<Privilege> privileges;

    public CompanyRoleResponse() {
    }

    public CompanyRoleResponse(CompanyRoles model) {
        this.id = model.getId();
        this.name = model.getName();
        this.privileges = List.copyOf(model.getPrivileges());
        if(model.getCompany() != null){
            this.companyId = model.getCompany().getId();
            this.companyName = model.getCompany().getEnName();
        }
    }
}
