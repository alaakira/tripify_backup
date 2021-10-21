package com.tripify.demo.company_roles.payloads.requests;

import java.util.List;

public class CompanyRoleRequest {

    public Long id;

    public String name;

    public List<Long> privilegesIds;

    public Long companyId;
}
