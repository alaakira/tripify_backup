package com.tripify.demo.roles.types;

public enum RoleTypes {
    ADMIN, CLIENT;

    public String getName() {
        switch (this) {
            case ADMIN:
                return "ADMIN";
            case CLIENT:
                return "CLIENT";
            default:
                return "";
        }
    }

    public String getRole(){
        switch (this) {
            case ADMIN:
                return "ROLE_ADMIN";
            case CLIENT:
                return "ROLE_CLIENT";
            default:
                return "";
        }
    }

    public String getRoleName(){
        switch (this) {
            case ADMIN:
                return "ADMIN";
            case CLIENT:
                return "CLIENT";
            default:
                return "";
        }
    }
}
