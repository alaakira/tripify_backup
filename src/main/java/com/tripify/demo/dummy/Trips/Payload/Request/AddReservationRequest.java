package com.tripify.demo.dummy.Trips.Payload.Request;

public class AddReservationRequest {

    Long tripId;
    int seatsNumber;

    public AddReservationRequest(Long tripId, int seatsNumber) {
        this.tripId = tripId;
        this.seatsNumber = seatsNumber;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }
}
