package com.tripify.demo;

import com.tripify.demo.consts.URLs;
import com.tripify.demo.users.admins.payloads.responses.AdminSignUpResponse;
import com.tripify.demo.message_handler.ResponseBody;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(URLs.ADMIN_PATH)
@PreAuthorize("hasAnyAuthority('ADMIN')")
//@RequestMapping("test/")
public class TestController {

    @GetMapping("hello")
    public ResponseBody<AdminSignUpResponse> hello(){
        return new ResponseBody<>(new AdminSignUpResponse("Hello"));
    }

}
