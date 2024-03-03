package com.brett.rental.domain.station;

import com.brett.rental.domain.bike.Bike;

import java.util.Map;

public record Inventory(Map<Bike, Quantity> bikes) {
    public static Inventory of(Map<Bike, Quantity> bikes) {
        return new Inventory(bikes);
    }
}
