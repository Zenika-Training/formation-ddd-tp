package com.zenika.ddd.order;

import com.zenika.ddd.course.stub.DeliveryManRepositoryStub;
import com.zenika.ddd.order.service.AcceptOrderDomainService;
import com.zenika.ddd.course.DeliveryManEntity;
import com.zenika.ddd.shared.OrderStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AcceptOrderDomainServiceTest {

    AcceptOrderDomainService acceptOrderDomainService = new AcceptOrderDomainService(new DeliveryManRepositoryStub());

    @Test
    @DisplayName("When an order is accepted, it should be in status accepted")
    void should_be_in_status_accepted_when_accepted() {
        // Given
        OrderEntity order = OrderEntity.builder().build();

        // When
        OrderEntity orderEntity = acceptOrderDomainService.accept(order);

        // Then
        assertEquals(OrderStatus.ACCEPTED, orderEntity.getStatus());
    }

    @Test
    @DisplayName("When an order is accepted, it should have a deliveryMan")
    void should_have_a_deliveryMan_when_accepted() {
        // Given
        OrderEntity order = OrderEntity.builder().id(UUID.fromString("afd0e3b4-0b3b-4b3b-8b3b-0b3b4b3b0b3b")).build();

        // When
        OrderEntity orderEntity = acceptOrderDomainService.accept(order);

        // Then
        assertNotNull(orderEntity.getDeliveryManEntity());
        assertNotNull(orderEntity.getDeliveryManEntity().getId());
        assertThat(orderEntity.getDeliveryManEntity()).extracting(
                DeliveryManEntity::getNom,
                DeliveryManEntity::getPrenom
                ).containsExactly(
                "nom",
                "prenom");
    }
}
