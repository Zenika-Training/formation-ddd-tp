package com.brett.rental.domain.station;

import com.brett.rental.domain.bike.Bike;

public record EnterInStock(Bike bike, int quantity) {
}
