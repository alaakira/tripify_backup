package com.tripify.demo.offices.privileges;

import com.tripify.demo.privileges.services.PrivilegeManager;
import com.tripify.demo.privileges.model.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("OfficePrivileges")
public class OfficePrivileges {
    public static final String MANAGE_OFFICE = "MANAGE_OFFICE";
    public static final String CREATE_OFFICE = "CREATE_OFFICE";
    public static final String EDIT_OFFICE = "EDIT_OFFICE";
    public static final String VIEW_OFFICE = "VIEW_OFFICE";
    public static final String DELETE_OFFICE = "DELETE_OFFICE";

    public static final String MANAGE_OFFICE_DESCRIPTION = "You have all privileges";
    public static final String CREATE_OFFICE_DESCRIPTION = "CREATE_OFFICE";
    public static final String EDIT_OFFICE_DESCRIPTION = "EDIT_OFFICE";
    public static final String VIEW_OFFICE_DESCRIPTION = "VIEW_OFFICE";
    public static final String DELETE_OFFICE_DESCRIPTION = "DELETE_OFFICE";

    static {
        setupPrivileges();
    }

    private static void setupPrivileges() {
        PrivilegeManager.setupManager(
        Pair.of(MANAGE_OFFICE,MANAGE_OFFICE_DESCRIPTION),
        Pair.of(CREATE_OFFICE,CREATE_OFFICE_DESCRIPTION),
        Pair.of(EDIT_OFFICE,EDIT_OFFICE_DESCRIPTION),
        Pair.of(VIEW_OFFICE,VIEW_OFFICE_DESCRIPTION),
        Pair.of(DELETE_OFFICE,DELETE_OFFICE_DESCRIPTION));
    }
}
