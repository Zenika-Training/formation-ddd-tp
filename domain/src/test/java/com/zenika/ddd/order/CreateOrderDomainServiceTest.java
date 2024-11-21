package com.zenika.ddd.order;

import com.zenika.ddd.course.DeliveryManEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateOrderDomainServiceTest {

    CreateOrderDomainService createOrderDomainService = new CreateOrderDomainService();

    @Test
    void should_throw_an_exception_if_deliveryMan_is_missing() {
        // Given
        OrderEntity order = OrderEntity.builder()
                .clientEntity(ClientEntity.builder().build())
                .deliveryManEntity(null)
                .build();

        // When
        assertThrows(IllegalArgumentException.class, () -> createOrderDomainService.receiveOrder(order));
    }

    @Test
    void should_throw_an_exception_if_client_is_missing() {
        // Given
        OrderEntity order = OrderEntity.builder()
                .clientEntity(null)
                .deliveryManEntity(DeliveryManEntity.builder().build())
                .build();

        // When
        assertThrows(IllegalArgumentException.class, () -> createOrderDomainService.receiveOrder(order));
    }

    @Test
    void should_throw_an_exception_if_some_uuid_are_missing() {
        // Given
        OrderEntity order = OrderEntity.builder()
                .clientEntity(ClientEntity.builder().build())
                .deliveryManEntity(DeliveryManEntity.builder().build())
                .orderStatus(OrderStatus.AVAILABLE)
                .build();

        // When
        assertThrows(IllegalArgumentException.class, () -> createOrderDomainService.receiveOrder(order));
    }
}
