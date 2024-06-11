package com.zenika.ddd.commande;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderEntityTest {

    @Test
    void OrderEntity_should_be_adStatus_created_when_created() {
        OrderEntity orderEntity = OrderEntity.builder()
                .id(UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479").toString())
                .build();
        assertEquals(OrderStatus.CREATED, orderEntity.getOrderStatus());
    }

    @Test
    void OrderEntity_should_be_set_to_status_payed_when_payed() {
        OrderEntity orderEntity = OrderEntity.builder()
                .id(UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479").toString())
                .build();
        orderEntity.pay();
        assertEquals(OrderStatus.PAYED, orderEntity.getOrderStatus());
    }

    @Test
    void OrderEntity_should_raise_an_exception_when_payed_twice() {
        OrderEntity orderEntity = OrderEntity.builder()
                .id(UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479").toString())
                .orderStatus(OrderStatus.PAYED)
                .build();
        assertThrows(IllegalStateException.class, () -> orderEntity.pay());
    }

    @Test
    void OrderEntity_should_raise_an_exception_when_payed_not_in_created_status() {
        OrderEntity orderEntity = OrderEntity.builder()
                .id(UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479").toString())
                .orderStatus(OrderStatus.SHIPPED)
                .build();
        assertThrows(IllegalStateException.class, () -> orderEntity.pay());
    }
}
