package com.tripify.demo.users.clients.services;

import com.tripify.demo.exceptions.AlreadyExistRuntimeException;
import com.tripify.demo.exceptions.IncorrectPasswordException;
import com.tripify.demo.exceptions.NotFoundRuntimeException;
import com.tripify.demo.jwt_utils.JWTUtils;
import com.tripify.demo.users.UserPrincipal;
import com.tripify.demo.users.admins.payloads.requests.AdminSignInRequest;
import com.tripify.demo.users.admins.payloads.responses.AdminSignInResponse;
import com.tripify.demo.users.admins.payloads.responses.AdminSignUpResponse;
import com.tripify.demo.users.clients.model.User;
import com.tripify.demo.users.clients.payloads.resquests.UserSignUpRequest;
import com.tripify.demo.users.clients.repositories.UserRepository;
import com.tripify.demo.users.types.UserTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientAuthServices implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JWTUtils jwtUtils;

    public AdminSignUpResponse saveUser(UserSignUpRequest request){
        User search = userRepository.findByPhone(request.phone).orElse(null);
        if(search != null)
            throw new AlreadyExistRuntimeException("User already exists");
        User user = new User(request);
        User result = userRepository.save(user);
        UserPrincipal principal = UserPrincipal.create(result);
        String token = jwtUtils.generateToken(principal, UserTypes.ADMIN.getType());
        return new AdminSignUpResponse(token);
    }

    public AdminSignInResponse signIn(AdminSignInRequest request){
        UserDetails details = loadUserByUsername(request.phone);
        if(!bCryptPasswordEncoder.matches(request.password, details.getPassword()))
            throw new IncorrectPasswordException();
        String token = jwtUtils.generateToken(details, UserTypes.ADMIN.getType());
        return new AdminSignInResponse(token);
    }


    @Override
    public UserDetails loadUserByUsername(String phone) throws NotFoundRuntimeException {
        User user = userRepository.findByPhone(phone).orElseThrow(() ->
                new NotFoundRuntimeException("User not found")
        );
        return UserPrincipal.create(user);
    }
}
