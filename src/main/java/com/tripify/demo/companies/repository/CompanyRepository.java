package com.tripify.demo.companies.repository;

import com.tripify.demo.companies.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

    Optional<Company> findByPhone(String number);
    Optional<Company> findByLandPhone(String number);
    Optional<Company> findByCertNum(String number);
    Optional<Company> findByOwnerId(Long id);
    Optional<Company> findByEmail(String email);
}
