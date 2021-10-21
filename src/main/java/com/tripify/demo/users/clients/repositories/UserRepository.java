package com.tripify.demo.users.clients.repositories;

import com.tripify.demo.users.clients.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByPhone(String phone);
}
