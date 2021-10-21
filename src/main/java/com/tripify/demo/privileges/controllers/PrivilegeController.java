package com.tripify.demo.privileges.controllers;

import com.tripify.demo.consts.URLs;
import com.tripify.demo.message_handler.ResponseBody;
import com.tripify.demo.privileges.payloads.responses.PrivilegeResponse;
import com.tripify.demo.privileges.services.PrivilegeCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(URLs.PRIVILEGES)
public class PrivilegeController {

    @Autowired
    private PrivilegeCRUDService service;

    @GetMapping("/{id}")
    public ResponseBody<PrivilegeResponse> getPrivilegeById(@PathVariable Long id){
        return new ResponseBody<>(service.getPrivilegeById(id));
    }

    @GetMapping("/")
    public ResponseBody<List<PrivilegeResponse>> getAllPrivileges(){
        return new ResponseBody<>(service.getAllPrivileges());
    }

}
