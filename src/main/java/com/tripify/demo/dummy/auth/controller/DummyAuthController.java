package com.tripify.demo.dummy.auth.controller;

import com.tripify.demo.consts.URLs;
import com.tripify.demo.dummy.Models.User;
import com.tripify.demo.dummy.auth.PayLoads.Requests.*;
import com.tripify.demo.dummy.auth.PayLoads.Responses.*;
import com.tripify.demo.exceptions.AlreadyExistRuntimeException;
import com.tripify.demo.exceptions.IncorrectCodeException;
import com.tripify.demo.exceptions.IncorrectPasswordException;
import com.tripify.demo.exceptions.NotFoundRuntimeException;
import com.tripify.demo.message_handler.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping(URLs.DUMMY_PATH)
public class DummyAuthController {



    public static ArrayList<User> users = new ArrayList<>(Arrays.asList(
                  new User("Fares","994942830","21-1-1997","male","12345",1l)));

    public DummyAuthController(){

    }

    @PostMapping(URLs.USER_PATH+URLs.DUMMY_SIGN_UP_Phone_URL)
    public ResponseBody<UserPhoneCheckSingUpResponse> checkphonesignup(@RequestBody UserPhoneCheckSingUpRequest request) {
        for (User user : users) {
            if (user.getPhone().equals(request.phone)) {
                throw new AlreadyExistRuntimeException("User already exists");
            }

        }
            return new ResponseBody<>(new UserPhoneCheckSingUpResponse(true,"Code sent succesfully"));
    }


    @PostMapping(URLs.USER_PATH+URLs.DUMMY_SIGN_UP_Enter_Code)
    public ResponseBody<EnterCodeResponse> entercode(@RequestBody EnterCodeRequest request) {

        if (request.code.equals("123456"))
        {
            return new ResponseBody<>(new EnterCodeResponse(true,"code is correct"));
        }
        else
        {
           throw   new IncorrectCodeException();
        }
    }


    @PostMapping(URLs.USER_PATH+URLs.SIGN_UP_URL)
    public ResponseBody<SingupResponse> singup(@RequestBody SingUpRequest request) {
        System.out.println(users.size());
        User user = new User(request.name,request.phone,request.birthday,request.birthday,request.password,users.size()+1l);
        users.add(user);

        return new ResponseBody<>(new SingupResponse("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIwOTMwNjY2MTk5IiwidXNlclR5cGUiOiJhZG4iLCJleHAiOjE2MjQxMjkwMjF9.UjnEDI4rJAe7Kse6NSi76-AQYxfOjZxmNrFTl80Mmto"));
    }

    @PostMapping(URLs.USER_PATH+URLs.SIGN_IN_URL)
    public ResponseBody<SingInResponse> singin(@RequestBody SingInRequest request) {

        for (User user : users)
        {
            if (user.getPhone().equals(request.phone))
            {
                if (user.getPassword().equals(request.password))
                {
                    return new ResponseBody<>(new SingInResponse("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIwOTMwNjY2MTk5IiwidXNlclR5cGUiOiJhZG4iLCJleHAiOjE2MjQxMjkwMjF9.UjnEDI4rJAe7Kse6NSi76-AQYxfOjZxmNrFTl80Mmto"));
                }
                else
                {
                    throw   new IncorrectPasswordException();
                }
            }
        }
        throw new NotFoundRuntimeException("User not found");
    }

    @PostMapping(URLs.USER_PATH+URLs.DUMMY_Change_Password)
    public ResponseBody<ChangePasswordResponse> changepassword(@RequestBody ChangePasswordRequest request) {

        String phonefromtoken  = "994942830";

              for (User user :users)
              {
                  if (phonefromtoken.equals(user.getPhone()))
                  {
                      if (user.getPassword().equals(request.oldPassword))
                      {
                          user.setPassword(request.newPassword);
                          return new ResponseBody<>(new ChangePasswordResponse("password changed",true));
                      }
                      else
                      {
                          throw new IncorrectPasswordException();
                      }
                  }
              }
              throw new NotFoundRuntimeException("User not found");
    }

    @PostMapping(URLs.USER_PATH+URLs.DUMMY_Change_Profile)
    public ResponseBody<ChangeProfileResponse> changeprofile(@RequestBody ChangeProfileRequest request) {

        String phonefromtoken  = "994942830";
        for (User user : users)

        {
            if (phonefromtoken==user.getPhone())
            {
                user.setBirthday(request.birthday);
                user.setName(request.name);
                user.setType(request.type);
                return new ResponseBody<>(new ChangeProfileResponse("Profile Changed Successfully",true));
            }
        }
            throw new NotFoundRuntimeException("User not found");

    }
















}
