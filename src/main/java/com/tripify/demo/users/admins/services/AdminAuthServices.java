package com.tripify.demo.users.admins.services;

import com.tripify.demo.exceptions.AlreadyExistRuntimeException;
import com.tripify.demo.exceptions.IncorrectPasswordException;
import com.tripify.demo.exceptions.NotFoundRuntimeException;
import com.tripify.demo.jwt_utils.JWTUtils;
import com.tripify.demo.users.UserPrincipal;
import com.tripify.demo.users.admins.models.Admin;
import com.tripify.demo.users.admins.payloads.requests.AdminSignInRequest;
import com.tripify.demo.users.admins.payloads.requests.AdminSignUpRequest;
import com.tripify.demo.users.admins.payloads.responses.AdminSignInResponse;
import com.tripify.demo.users.admins.payloads.responses.AdminSignUpResponse;
import com.tripify.demo.users.admins.repositories.AdminRepository;
import com.tripify.demo.users.types.UserTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthServices implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JWTUtils jwtUtils;

    public AdminSignUpResponse signUpAdmin(AdminSignUpRequest request){
        Admin search = adminRepository.findByPhone(request.phone).orElse(null);
        if(search != null)
            throw new AlreadyExistRuntimeException("User already exists");
        Admin user = new Admin(request.phone, bCryptPasswordEncoder.encode(request.password));
        Admin result = adminRepository.save(user);
        UserPrincipal principal = UserPrincipal.create(result);
        String token = jwtUtils.generateToken(principal, UserTypes.ADMIN.getType());
        return new AdminSignUpResponse(token);
    }

    public AdminSignInResponse signInAdmin(AdminSignInRequest request){
        UserDetails details = loadUserByUsername(request.phone);
        if(!bCryptPasswordEncoder.matches(request.password, details.getPassword()))
            throw new IncorrectPasswordException();
        String token = jwtUtils.generateToken(details, UserTypes.ADMIN.getType());
        return new AdminSignInResponse(token);
    }

    @Override
    public UserDetails loadUserByUsername(String phone) throws NotFoundRuntimeException {
        Admin admin = adminRepository.findByPhone(phone).orElseThrow(() ->
                new NotFoundRuntimeException("User not found")
        );
        return UserPrincipal.create(admin);
    }

}
