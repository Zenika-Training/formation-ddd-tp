package com.brett.catalog.domain;

public record AmountInCents(int amount) {

    public static AmountInCents of(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        return new AmountInCents(amount);
    }

}
