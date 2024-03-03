package com.brett.rental.domain.bike;

public record Model(String name) {
    public static Model of(String name) {
        return new Model(name);
    }
}
