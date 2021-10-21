package com.tripify.demo.company_roles.controllers;

import com.tripify.demo.company_roles.payloads.requests.CompanyRoleRequest;
import com.tripify.demo.company_roles.payloads.responses.CompanyRoleResponse;
import com.tripify.demo.company_roles.services.CompanyRolesService;
import com.tripify.demo.consts.URLs;
import com.tripify.demo.message_handler.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(URLs.COMPANY_ROLES)
@PreAuthorize("hasRole('ADMIN')")
public class CompanyRolesController {

    @Autowired
    private CompanyRolesService service;

    @PostMapping("")
    public ResponseBody<CompanyRoleResponse> addCompanyRole(@RequestBody CompanyRoleRequest request,
                                                            HttpServletRequest httpServletRequest){
        return new ResponseBody<>(service.createRole(request));
    }

    @PutMapping("")
    public ResponseBody<CompanyRoleResponse> editCompanyRole(@RequestBody CompanyRoleRequest request,
                                                            HttpServletRequest httpServletRequest){
        return new ResponseBody<>(service.updateRole(request));
    }

    @GetMapping("/{id}")
    public ResponseBody<CompanyRoleResponse> getCompanyRoleById(@PathVariable Long id,
                                                             HttpServletRequest httpServletRequest){
        return new ResponseBody<>(service.getRoleById(id));
    }

    @GetMapping("")
    public ResponseBody<List<CompanyRoleResponse>> getCompanyRoleByCompanyId(@RequestParam("companyId") Long id,
                                                                             HttpServletRequest httpServletRequest){
        return new ResponseBody<>(service.getRoleByCompanyId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseBody<CompanyRoleResponse> deleteCompanyRoleById(@PathVariable Long id,
                                                                HttpServletRequest httpServletRequest){
        return new ResponseBody<>(service.deleteCompanyRole(id));
    }
}
