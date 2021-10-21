package com.tripify.demo.users.admins.controllers;

import com.tripify.demo.users.admins.payloads.requests.AdminSignInRequest;
import com.tripify.demo.users.admins.payloads.requests.AdminSignUpRequest;
import com.tripify.demo.users.admins.payloads.responses.AdminSignInResponse;
import com.tripify.demo.users.admins.payloads.responses.AdminSignUpResponse;
import com.tripify.demo.users.admins.services.AdminAuthServices;
import com.tripify.demo.consts.URLs;
import com.tripify.demo.message_handler.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(URLs.ADMIN_AUTH)
public class AdminAuthenticationController {

    private final AdminAuthServices adminAuthServices;

    public AdminAuthenticationController(AdminAuthServices adminAuthServices) {
        this.adminAuthServices = adminAuthServices;
    }

    @PostMapping(URLs.SIGN_IN_URL)
    public ResponseBody<AdminSignInResponse> signInAdmin(@RequestBody AdminSignInRequest adminSignInRequest){
        AdminSignInResponse response = adminAuthServices.signInAdmin(adminSignInRequest);
        return new ResponseBody<>(response);
    }

    @PostMapping(URLs.SIGN_UP_URL)
    public ResponseBody<AdminSignUpResponse> signUpAdmin( @RequestBody AdminSignUpRequest adminSignUpRequest){
        AdminSignUpResponse response = adminAuthServices.signUpAdmin(adminSignUpRequest);
        return new ResponseBody<>(response);
    }

}
