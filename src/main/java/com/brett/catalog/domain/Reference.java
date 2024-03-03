package com.brett.catalog.domain;

import lombok.Getter;

import java.util.Map;

@Getter
public class Reference {
    private final Code code;
    private String name;
    private String description;
    private PricePerDay pricePerDay;
    private Map<String, String> characteristics;

    public Reference(Code code, String name, String description, PricePerDay pricePerDay, Map<String, String> characteristics) {
        if(characteristics.isEmpty()) {
            throw new IllegalArgumentException("Characteristics cannot be empty");
        }

        this.code = code;
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.description = description;
        this.characteristics = characteristics;
    }

    public static Reference make(Code code, String name, String description, PricePerDay pricePerDay, Map<String, String> characteristics) {
        return new Reference(code, name, description, pricePerDay, characteristics);
    }

    public void addCharacteristic(String characteristic, String value) {
        characteristics.put(characteristic, value);
    }
}
