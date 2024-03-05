package com.brett.catalog.domain.prix;

import java.util.UUID;

public record PrixVeloId(UUID uuid) {
    public static PrixVeloId generate() {
        return new PrixVeloId(UUID.randomUUID());
    }
}
