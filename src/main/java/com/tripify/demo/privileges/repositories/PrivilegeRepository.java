package com.tripify.demo.privileges.repositories;

import com.tripify.demo.privileges.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {

    public Optional<Privilege> findByName(String name);

}
