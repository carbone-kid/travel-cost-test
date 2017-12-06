package com.sfirsov.klmtest.model;

import lombok.Value;

@Value
public class FareResponse {
    private Location origin;
    private Location destination;
    private Fare fare;

    public FareResponse(Location origin, Location destination, Fare fare) {
        this.origin = origin;
        this.destination = destination;
        this.fare = fare;
    }
}
