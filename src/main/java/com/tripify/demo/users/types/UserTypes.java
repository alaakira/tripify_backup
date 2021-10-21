package com.tripify.demo.users.types;

public enum UserTypes {
    EMPLOYEE,DRIVER,CLIENT,ADMIN;
    public String getType(){
        switch (this){
            case CLIENT:{ return "cln";}
            case DRIVER:{ return "drv";}
            case EMPLOYEE:{ return "emp";}
            case ADMIN:{ return "adn";}
            default: return null;
        }
    }
}
