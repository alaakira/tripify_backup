package com.tripify.demo.dummy.Models;

import java.util.List;

public class Trip {

    long id;

    long fromcityid;
    City fromcity;
    long fromofficeid;
    Office fromoffice;
    long tocityid;
    City tocity;
    long toofficeid;
    Office tooffice;
    String startdate;
    String starttime;
    long companyid;
    Company company;
    List<PassPoint>passPoints;
    int seats;
    double rate;
    String price;


    public Trip(long id, long fromcityid, City fromcity, long fromofficeid, Office fromoffice, long tocityid, City tocity, long toofficeid, Office tooffice, String startdate, String starttime, long companyid, Company company,List<PassPoint>passPoints,int seats,double rate,String price) {
        this.id = id;
        this.fromcityid = fromcityid;
        this.fromcity = fromcity;
        this.fromofficeid = fromofficeid;
        this.fromoffice = fromoffice;
        this.tocityid = tocityid;
        this.tocity = tocity;
        this.toofficeid = toofficeid;
        this.tooffice = tooffice;
        this.startdate = startdate;
        this.starttime = starttime;
        this.companyid = companyid;
        this.company = company;
        this.passPoints=passPoints;
        this.seats=seats;
        this.rate=rate;
        this.price=price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFromcityid() {
        return fromcityid;
    }

    public void setFromcityid(long fromcityid) {
        this.fromcityid = fromcityid;
    }

    public City getFromcity() {
        return fromcity;
    }

    public void setFromcity(City fromcity) {
        this.fromcity = fromcity;
    }

    public long getFromofficeid() {
        return fromofficeid;
    }

    public void setFromofficeid(long fromofficeid) {
        this.fromofficeid = fromofficeid;
    }

    public Office getFromoffice() {
        return fromoffice;
    }

    public void setFromoffice(Office fromoffice) {
        this.fromoffice = fromoffice;
    }

    public long getTocityid() {
        return tocityid;
    }

    public void setTocityid(long tocityid) {
        this.tocityid = tocityid;
    }

    public City getTocity() {
        return tocity;
    }

    public void setTocity(City tocity) {
        this.tocity = tocity;
    }

    public long getToofficeid() {
        return toofficeid;
    }

    public void setToofficeid(long toofficeid) {
        this.toofficeid = toofficeid;
    }

    public Office getTooffice() {
        return tooffice;
    }

    public void setTooffice(Office tooffice) {
        this.tooffice = tooffice;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public long getCompanyid() {
        return companyid;
    }

    public void setCompanyid(long companyid) {
        this.companyid = companyid;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public List<PassPoint> getPassPoints() {
        return passPoints;
    }

    public void setPassPoints(List<PassPoint> passPoints) {
        this.passPoints = passPoints;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
