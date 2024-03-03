package com.brett.catalog.domain;

public record PricePerDay(AmountInCents amount) {
    public static PricePerDay of(AmountInCents amount) {
        return new PricePerDay(amount);
    }
}
