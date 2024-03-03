package com.brett.rental.domain.bike;

public record Make(String name) {
    public static Make of(String name) {
        return new Make(name);
    }
}
