package com.brett.rental.domain.station;

public record Quantity(int amount) {
    public static Quantity of(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be >= 0");
        return new Quantity(amount);
    }

    public Quantity add(Quantity quantity) {
        return new Quantity(amount + quantity.amount);
    }
}
