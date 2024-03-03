package com.brett.rental.domain.station;

import java.util.UUID;

public record StationId(UUID id) {
    public static StationId generate() {
        return new StationId(UUID.randomUUID());
    }
}
