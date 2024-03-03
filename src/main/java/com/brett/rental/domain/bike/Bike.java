package com.brett.rental.domain.bike;

public record Bike(Make make, Model model) {
    public static Bike of(Make make, Model model) {
        return new Bike(make, model);
    }
}
