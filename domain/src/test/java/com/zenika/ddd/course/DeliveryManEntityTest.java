package com.zenika.ddd.course;

import com.zenika.ddd.shared.Position;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryManEntityTest {

    @Test
    @Disabled
    void delivery_man_should_move_to_position() {
        // Given
        DeliveryManEntity deliveryMan = new DeliveryManEntity(
                "Outan",
                "Laurent",
                new Position(47.216620, -1.577638),
                "laurent.outant@gmail.com"
        );
        Position destinationPosition = new Position(47.271912, -1.501013);

        // When
        deliveryMan.moveToPosition(destinationPosition, 0.001f);

        // Then
        assertTrue(deliveryMan.getPosition().isCloseToPosition(destinationPosition, 0.001f));
    }
}
