package com.brett.catalog.domain;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReferenceTest {
    @Test
    public void cantHaveEmptyCharacteristics() {
        assertThrows(IllegalArgumentException.class,
                () -> new Reference(
                        Code.of("code"),
                        "name",
                        "description",
                        PricePerDay.of(AmountInCents.of(10000)),
                        Map.of()));
    }

    @Test
    public void canAddCharacteristics() {
        var vanRyseRef = Fixtures.vanRyselReference();
        vanRyseRef.addCharacteristic("color", "red");
        assertEquals("red", vanRyseRef.getCharacteristics().get("color"));
    }
}