package com.zenika.ddd.shared;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void should_return_true_when_position_is_close_because_of_position() {
        // Given
        Position position = new Position(48.8566, 2.3522);

        // When
        boolean isClose = position.isCloseToPosition(new Position(48.8566, 2.3522), 1f);

        // Then
        assertTrue(isClose);
    }

    @Test
    void should_return_true_when_position_is_close_because_of_distance() {
        // Given
        Position position = new Position(48.8566, 2.3522);

        // When
        boolean isClose = position.isCloseToPosition(new Position(51, 1), 5f);

        // Then
        assertTrue(isClose);
    }

    @Test
    void should_return_false_when_position_is_far_because_of_position() {
        // Given
        Position position = new Position(48.8566, 2.3522);

        // When
        boolean isClose = position.isCloseToPosition(new Position(50.8566, 3.3522), 1f);

        // Then
        assertFalse(isClose);
    }

}
