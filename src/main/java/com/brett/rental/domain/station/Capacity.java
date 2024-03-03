package com.brett.rental.domain.station;

public record Capacity(int amount) {
    public static Capacity of(int amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Can't have a capacity of 0 or less bikes");
        }
        return new Capacity(amount);
    }
}
