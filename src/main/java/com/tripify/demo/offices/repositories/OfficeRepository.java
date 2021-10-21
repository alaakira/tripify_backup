package com.tripify.demo.offices.repositories;

import com.tripify.demo.offices.models.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OfficeRepository extends JpaRepository<Office,Long> {

    Optional<List<Office>> getOfficesByCompanyId(Long id);

}
