package com.tripify.demo.users.clients.controllers;

import com.tripify.demo.consts.URLs;
import com.tripify.demo.message_handler.ResponseBody;
import com.tripify.demo.users.clients.model.User;
import com.tripify.demo.users.clients.services.UserServices;
import com.tripify.demo.users.clients.payloads.resquests.UserSignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(URLs.CLIENT_AUTH+URLs.USER_PATH)
public class UsersController {

    @Autowired
    private UserServices userServices;

//    @PostMapping(URLs.SIGN_UP_URL)
//    public ResponseBody<User> createUser(@RequestBody UserSignUpRequest request){
//        User result = userServices.createUser(request);
//        return new ResponseBody<>(result);
//    }

}
