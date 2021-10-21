package com.tripify.demo.users.clients.services;

import com.tripify.demo.company_roles.repositories.CompanyRolesRepository;
import com.tripify.demo.exceptions.AlreadyExistRuntimeException;
import com.tripify.demo.exceptions.IdNotFoundException;
import com.tripify.demo.users.clients.model.User;
import com.tripify.demo.users.clients.payloads.resquests.EmployeeSignUpRequest;
import com.tripify.demo.users.clients.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRolesRepository companyRolesRepository;

    public User createUser(EmployeeSignUpRequest request) {
        if (userRepository.findByPhone(request.phone).isPresent())
            throw new AlreadyExistRuntimeException("User already exists");
        User userPayload = new User(request);
        userPayload.setRoles(companyRolesRepository.findById(request.roleId).orElseThrow(() -> new IdNotFoundException("Role Id not found")));
        return userRepository.save(userPayload);
    }

    public void linkId(User user) {
        if (user.getId() != null)
            userRepository.save(user);
    }

}
