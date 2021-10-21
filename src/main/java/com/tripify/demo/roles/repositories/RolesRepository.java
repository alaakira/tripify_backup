package com.tripify.demo.roles.repositories;

import com.tripify.demo.roles.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Long> {

    public Optional<Roles> findByName(String name);

}
