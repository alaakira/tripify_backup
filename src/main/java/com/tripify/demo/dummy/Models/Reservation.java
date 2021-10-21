package com.tripify.demo.dummy.Models;

public class Reservation {

    Long id;
    Long userId;
    Long tripId;
    Trip trip;
    int seatsNumber;
    boolean isimprove;


    public Reservation(Long id, Long userId, Long tripId, Trip trip, int seatsNumber,boolean isimprove) {
        this.id = id;
        this.userId = userId;
        this.tripId = tripId;
        this.trip = trip;
        this.seatsNumber = seatsNumber;
        this.isimprove=isimprove;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }
}
