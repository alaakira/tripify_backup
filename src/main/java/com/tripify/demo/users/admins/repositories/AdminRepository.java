package com.tripify.demo.users.admins.repositories;

import com.tripify.demo.users.admins.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findByPhone(String phone);
}
