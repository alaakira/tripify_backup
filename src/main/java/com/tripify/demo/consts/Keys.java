package com.tripify.demo.consts;

public enum Keys {
    AUTHORIZATION,USER_TYPE,USER_ROLE;

    public String getName(){
        switch (this){
            case AUTHORIZATION: return "Authorization";
            case USER_TYPE: return "userType";
            case USER_ROLE: return "userRole";
        }
        return "";
    }
}
