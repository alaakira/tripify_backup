package com.tripify.demo.dummy.Trips.Payload.Response;

import com.tripify.demo.dummy.Models.Trip;

public class GetTripResponse {

    Trip trip;


    public GetTripResponse(Trip trip) {
        this.trip = trip;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
