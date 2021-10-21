package com.tripify.demo.roles.types;

import com.tripify.demo.companies.privileges.CompanyPrivileges;
import com.tripify.demo.privileges.model.Privilege;
import com.tripify.demo.privileges.services.PrivilegeManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("RoleTypes")
public class RoleTypesComponent {

    public static List<String> getAdminPrivileges(){
        return new ArrayList<>(PrivilegeManager.privilegeHashMap.keySet());
    }

    public static List<Privilege> getOwnerPrivilegesIds(){
        List<Privilege> privileges = new ArrayList<>(List.copyOf(PrivilegeManager.privilegeHashMap.values()));
        List<Privilege> excludedPrivileges = CompanyPrivileges.getPrivileges();
        privileges.removeAll(excludedPrivileges);
        return privileges;
    }
}
