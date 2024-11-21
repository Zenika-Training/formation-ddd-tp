package com.zenika.ddd.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcceptOrderDomainServiceTest {

    AcceptOrderDomainService acceptOrderDomainService = new AcceptOrderDomainService();

    @Test
    @DisplayName("When an order is accepted, it should be in status accepted")
    void should_be_in_status_accepted_when_accepted() {
        // Given
        OrderEntity order = new OrderEntity();

        // When
        OrderEntity orderEntity = acceptOrderDomainService.accept(order);

        // Then
        assertEquals(OrderStatus.ACCEPTED, orderEntity.getOrderStatus());
    }

}
