package com.tripify.demo.dummy.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

    private String name;
    private String phone;
    private String birthday;
    private String type;
    private String password;
    private Long id;

    public User(String name, String phone, String birthday, String type, String password , Long id) {
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.type = type;
        this.password = password;
        this.id=id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
