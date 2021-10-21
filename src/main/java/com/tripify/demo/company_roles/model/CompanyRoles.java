package com.tripify.demo.company_roles.model;

import com.tripify.demo.companies.models.Company;
import com.tripify.demo.company_roles.payloads.requests.CompanyRoleRequest;
import com.tripify.demo.consts.ColumnsNames;
import com.tripify.demo.consts.TablesNames;
import com.tripify.demo.privileges.model.Privilege;
import com.tripify.demo.users.admins.models.Admin;
import com.tripify.demo.users.clients.model.Employee;
import com.tripify.demo.users.clients.model.User;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = TablesNames.companyRoles)
@Data
public class CompanyRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = ColumnsNames.name)
    private String name;

    @ManyToOne
    private Company company;

    @ManyToMany
    @JoinTable(
            name = TablesNames.company_role_permission,
            joinColumns = @JoinColumn(name = ColumnsNames.roleId,referencedColumnName = ColumnsNames.id),
            inverseJoinColumns = @JoinColumn(name = ColumnsNames.privilegeId,referencedColumnName = ColumnsNames.id))
    private Collection<Privilege> privileges;

    public CompanyRoles() {
    }

    public CompanyRoles(CompanyRoleRequest request, Company company) {
        this.id = request.id;
        this.name = request.name;
        this.company = company;
    }

}
