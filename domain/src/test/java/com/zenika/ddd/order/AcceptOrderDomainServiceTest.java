package com.zenika.ddd.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AcceptOrderDomainServiceTest {

    AcceptOrderDomainService acceptOrderDomainService = new AcceptOrderDomainService(new DeliveryManStub());

    @Test
    @DisplayName("When an order is accepted, it should be in status accepted")
    void should_be_in_status_accepted_when_accepted() {
        // Given
        OrderEntity order = new OrderEntity();

        // When
        OrderEntity orderEntity = acceptOrderDomainService.accept(order);

        // Then
        assertEquals(Status.ACCEPTED, orderEntity.getStatus());
    }

    @Test
    @DisplayName("When an order is accepted, it should have a deliveryMan")
    void should_have_a_deliveryMan_when_accepted() {
        // Given
        OrderEntity order = OrderEntity.builder()
                .id(UUID.fromString("afd0e3b4-0b3b-4b3b-8b3b-0b3b4b3b0b3b"))
                .build();

        // When
        OrderEntity orderEntity = acceptOrderDomainService.accept(order);

        // Then
        assertNotNull(orderEntity.getDeliveryManEntity());
        assertThat(orderEntity.getDeliveryManEntity()).extracting(
                DeliveryManEntity::getId,
                DeliveryManEntity::getNom,
                DeliveryManEntity::getPrenom
                ).containsExactly(UUID.fromString("afd0e3b4-0b3b-4b3b-8b3b-0b3b4b3b0b3b"),
                "nom",
                "prenom");
    }
}
