package com.tripify.demo.dummy.Models;

public class Office {

    long id ;
    long city_id;
    String ar_name;
    String en_name;
    String address;
    Double lng;
    Double lat;
    Long Companyid;
    String phone;

    public Office(long id, long city_id, String ar_name, String en_name, String address, Double lng, Double lat,Long companyid,String phone) {
        this.id = id;
        this.city_id = city_id;
        this.ar_name = ar_name;
        this.en_name = en_name;
        this.address = address;
        this.lng = lng;
        this.lat = lat;
        this.Companyid=companyid;
        this.phone=phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCity_id() {
        return city_id;
    }

    public void setCity_id(long city_id) {
        this.city_id = city_id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Long getCompanyid() {
        return Companyid;
    }

    public void setCompanyid(Long companyid) {
        Companyid = companyid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
