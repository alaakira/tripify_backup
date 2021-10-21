package com.tripify.demo.offices.controllers;

import com.tripify.demo.consts.URLs;
import com.tripify.demo.message_handler.ResponseBody;
import com.tripify.demo.offices.payloads.requests.OfficeRequest;
import com.tripify.demo.offices.payloads.responses.OfficeResponse;
import com.tripify.demo.offices.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(URLs.OFFICE_PATH)
public class OfficeController {

    @Autowired
    private OfficeService service;

    @PostMapping("/")
    @PreAuthorize("hasAnyAuthority(T(com.tripify.demo.offices.privileges.OfficePrivileges).CREATE_OFFICE," +
            "T(com.tripify.demo.offices.privileges.OfficePrivileges).MANAGE_OFFICE)")
    public ResponseBody<OfficeResponse> addOffice(@RequestBody OfficeRequest officeRequest){
        return new ResponseBody<>(service.addOffice(officeRequest));
    }

    @PutMapping("/")
    @PreAuthorize("hasAnyAuthority(T(com.tripify.demo.offices.privileges.OfficePrivileges).EDIT_OFFICE," +
            "T(com.tripify.demo.offices.privileges.OfficePrivileges).MANAGE_OFFICE)")
    public ResponseBody<OfficeResponse> editOffice(@RequestBody OfficeRequest officeRequest,
                                                  HttpServletRequest servletRequest){
        return new ResponseBody<>(service.editOffice(officeRequest));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority(T(com.tripify.demo.offices.privileges.OfficePrivileges).VIEW_OFFICE," +
            "T(com.tripify.demo.offices.privileges.OfficePrivileges).MANAGE_OFFICE)")
    public ResponseBody<OfficeResponse> getOfficeById(@PathVariable("id") Long id,
                                                  HttpServletRequest servletRequest){
        return new ResponseBody<>(service.getOfficeById(id));
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority(T(com.tripify.demo.offices.privileges.OfficePrivileges).VIEW_OFFICE," +
            "T(com.tripify.demo.offices.privileges.OfficePrivileges).MANAGE_OFFICE)")
    public ResponseBody<List<OfficeResponse>> getOfficeByCompanyId(@RequestParam ("companyId") Long id,
                                                                   HttpServletRequest servletRequest){
        return new ResponseBody<>(service.getOfficeByCompanyId(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority(T(com.tripify.demo.offices.privileges.OfficePrivileges).DELETE_OFFICE," +
            "T(com.tripify.demo.offices.privileges.OfficePrivileges).MANAGE_OFFICE)")
    public ResponseBody<OfficeResponse> deleteOfficeById(@PathVariable("id") Long id,
                                                         HttpServletRequest servletRequest){
        return new ResponseBody<>(service.deleteOfficeById(id));
    }

}
