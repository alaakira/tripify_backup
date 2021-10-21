package com.tripify.demo.dummy.Models;

public class PassPoint {

    Long id;
    String ar_name;
    String en_name;
    String address;
    double lng;
    double lat;


    public PassPoint(long id,String ar_name, String en_name, String address, double lng, double lat) {
        this.id=id;
        this.ar_name = ar_name;
        this.en_name = en_name;
        this.address = address;
        this.lng = lng;
        this.lat = lat;
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

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
