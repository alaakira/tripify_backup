package com.tripify.demo.dummy.Models;

public class City {

    long id;
    String ar_name;
    String en_name;

    public City(long id, String ar_name, String en_name) {
        this.id = id;
        this.ar_name = ar_name;
        this.en_name = en_name;
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
}
