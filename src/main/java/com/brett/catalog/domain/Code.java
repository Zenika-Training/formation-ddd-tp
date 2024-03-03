package com.brett.catalog.domain;

public record Code(String code) {
    public Code {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Code cannot be null or blank");
        }
    }

    public static Code of(String code) {
        return new Code(code);
    }

    public static Code generate() {
        return new Code(java.util.UUID.randomUUID().toString());
    }
}
