package com.brett.rental.domain.station;

import com.brett.rental.domain.bike.Bike;

public record Entry(Bike bike, Quantity quantity) {
    public static Entry of(Bike bike, Quantity quantity) {
        return new Entry(bike, quantity);
    }
}
