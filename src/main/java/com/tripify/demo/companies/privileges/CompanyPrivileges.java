package com.tripify.demo.companies.privileges;

import com.tripify.demo.privileges.model.Privilege;
import com.tripify.demo.privileges.services.PrivilegeManager;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("CompanyPrivileges")
public class CompanyPrivileges {

    private static final ArrayList<Privilege> privileges = new ArrayList<>();

    public CompanyPrivileges() {
    }

    public static final String MANAGE_COMPANIES = "MANAGE_COMPANY";
    public static final String CREATE_COMPANY = "CREATE_COMPANY";
    public static final String EDIT_COMPANY = "EDIT_COMPANY";
    public static final String VIEW_COMPANY = "VIEW_COMPANY";
    public static final String DELETE_COMPANY = "DELETE_COMPANY";

    public static final String MANAGE_COMPANY_DESCRIPTION = "You have all privileges";
    public static final String CREATE_COMPANY_DESCRIPTION = "CREATE_COMPANY";
    public static final String EDIT_COMPANY_DESCRIPTION = "EDIT_COMPANY";
    public static final String VIEW_COMPANY_DESCRIPTION = "VIEW_COMPANY";
    public static final String DELETE_COMPANY_DESCRIPTION = "DELETE_COMPANY";

    static {
        setupPrivileges();
        privileges.add(PrivilegeManager.privilegeHashMap.get(MANAGE_COMPANIES));
        privileges.add(PrivilegeManager.privilegeHashMap.get(CREATE_COMPANY));
        privileges.add(PrivilegeManager.privilegeHashMap.get(EDIT_COMPANY));
        privileges.add(PrivilegeManager.privilegeHashMap.get(VIEW_COMPANY));
        privileges.add(PrivilegeManager.privilegeHashMap.get(DELETE_COMPANY));
    }

    private static void setupPrivileges() {
        PrivilegeManager.setupManager(
                Pair.of(MANAGE_COMPANIES,MANAGE_COMPANY_DESCRIPTION),
                Pair.of(CREATE_COMPANY,CREATE_COMPANY_DESCRIPTION),
                Pair.of(EDIT_COMPANY,EDIT_COMPANY_DESCRIPTION),
                Pair.of(VIEW_COMPANY,VIEW_COMPANY_DESCRIPTION),
                Pair.of(DELETE_COMPANY,DELETE_COMPANY_DESCRIPTION));
    }

    public static List<Privilege> getPrivileges(){
        return List.copyOf(privileges);
    }

}
