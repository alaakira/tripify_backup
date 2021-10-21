package com.tripify.demo.company_roles.repositories;

import com.tripify.demo.company_roles.model.CompanyRoles;
import com.tripify.demo.roles.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRolesRepository extends JpaRepository<CompanyRoles,Long> {

    Optional<CompanyRoles> findByName(String name);

    Optional<List<CompanyRoles>> findByCompany_Id(Long id);

}
