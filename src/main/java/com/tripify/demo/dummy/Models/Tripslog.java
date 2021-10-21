package com.tripify.demo.dummy.Models;

public class Tripslog {

    long Tripid;
    Trip trip;
    boolean isimprove;


    public Tripslog(long tripid,Trip trip, boolean isimprove) {
        Tripid = tripid;
        this.trip=trip;
        this.isimprove = isimprove;
    }

    public long getTripid() {
        return Tripid;
    }

    public void setTripid(long tripid) {
        Tripid = tripid;
    }

    public boolean isIsimprove() {
        return isimprove;
    }

    public void setIsimprove(boolean isimprove) {
        this.isimprove = isimprove;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
