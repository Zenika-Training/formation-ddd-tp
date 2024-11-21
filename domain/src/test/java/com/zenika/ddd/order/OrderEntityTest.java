package com.zenika.ddd.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderEntityTest {


    @Test
    @DisplayName("When an order is created, it should be in status available")
    void should_be_in_status_available_when_created() {
        // When
        OrderEntity order = new OrderEntity();

        // Then
        assertEquals(Status.AVAILABLE, order.getStatus());
    }

}
