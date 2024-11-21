package com.zenika.ddd.order;

import com.zenika.ddd.shared.Adresse;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CreateOrderDomainServiceTest {

    CreateOrderDomainService createOrderDomainService = new CreateOrderDomainService();

    @Test
    void should_throw_an_exception_if_deliveryMan_is_missing() {
        // Given

        OrderEntity order = OrderEntity.builder()
                .clientEntity(ClientEntity.builder()
                        .nom("toto")
                        .prenom("prenomtiti")
                        .adresse(Adresse.builder().build())
                        .build())
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
                .clientEntity(ClientEntity.builder()
                        .nom("toto")
                        .prenom("prenomtiti")
                        .adresse(Adresse.builder().build())
                        .build())
                .deliveryManEntity(DeliveryManEntity.builder().build())
                .status(Status.AVAILABLE)
                .build();

        // When
        assertThrows(IllegalArgumentException.class, () -> createOrderDomainService.receiveOrder(order));
    }

    @Test
    void should_create_an_order() {
        // given
        OrderEntity order = OrderEntity.builder()
                .id(UUID.randomUUID())
                .clientEntity(ClientEntity.builder()
                        .nom("toto")
                        .prenom("prenomtiti")
                        .adresse(Adresse.builder().build())
                        .build())
                .deliveryManEntity(DeliveryManEntity.builder().build())
                .build();

        // when
        OrderEntity receiveOrder = createOrderDomainService.receiveOrder(order);

        // then
        assertEquals(Status.AVAILABLE, receiveOrder.getStatus());
    }
}
