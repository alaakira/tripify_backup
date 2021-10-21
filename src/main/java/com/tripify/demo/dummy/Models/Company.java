package com.tripify.demo.dummy.Models;

import java.util.List;

public class Company {

    long id;
    String ar_name;
    String en_name;
    String logo;
    String phone;
    String address;
    List<Office>offices;


    public Company(long id, String ar_name, String en_name, String logo, String phone, String address, List<Office> offices) {
        this.id = id;
        this.ar_name = ar_name;
        this.en_name = en_name;
        this.logo = logo;
        this.phone = phone;
        this.address = address;
        this.offices = offices;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAr_name() {
        return ar_name;
    }

    public void setAr_name(String ar_name) {
        this.ar_name = ar_name;
    }

    public String getEn_name() {
        return en_name;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }
}
