package com.brett.rental.domain.station;

public record StationName(String value) {
    public static StationName of(String value) {
        return new StationName(value);
    }
}
