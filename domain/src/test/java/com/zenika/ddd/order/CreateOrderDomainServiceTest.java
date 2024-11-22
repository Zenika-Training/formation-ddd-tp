package com.zenika.ddd.order;

import com.zenika.ddd.order.model.CustomerEntity;
import com.zenika.ddd.order.model.DeliveryManEntity;
import com.zenika.ddd.order.model.OrderEntity;
import com.zenika.ddd.order.model.Status;
import com.zenika.ddd.order.services.CreateOrderDomainService;
import com.zenika.ddd.shared.Adresse;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CreateOrderDomainServiceTest {

    OrderRepositoryStub orderRepositoryStub = new OrderRepositoryStub();
    CreateOrderDomainService createOrderDomainService = new CreateOrderDomainService(orderRepositoryStub);

    @Test
    void should_throw_an_exception_if_client_is_missing() {
        // Given
        OrderEntity order = OrderEntity.builder()
                .customerEntity(null)
                .deliveryManEntity(DeliveryManEntity.builder().build())
                .build();

        // When
        assertThrows(IllegalArgumentException.class, () -> createOrderDomainService.receiveOrder(order));
    }

    @Test
    void should_throw_an_exception_if_some_uuid_are_missing() {
        // Given
        OrderEntity order = OrderEntity.builder()
                .customerEntity(CustomerEntity.builder()
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
    void should_create_an_order_not_exist() {
        // given
        OrderEntity order = OrderEntity.builder()
                .id(UUID.fromString("afd0e3b4-0b3b-4b3b-8b3b-0b3b4b3b0b3b"))
                .customerEntity(CustomerEntity.builder()
                        .nom("toto")
                        .prenom("prenomtiti")
                        .adresse(Adresse.builder().build())
                        .build())
                .deliveryManEntity(DeliveryManEntity.builder().build())
                .build();

        // when
        createOrderDomainService.receiveOrder(order);

        // then
        Optional<OrderEntity> orderEntity = orderRepositoryStub.getById("afd0e3b4-0b3b-4b3b-8b3b-0b3b4b3b0b3b");
        assertEquals(Optional.empty(), orderEntity);
    }


    @Test
    void should_create_an_order_existing() {
        // given
        OrderEntity order = OrderEntity.builder()
                .id(UUID.fromString("afd0e3b4-0b3b-0000-8b3b-0b3b4b3b0b3b"))
                .customerEntity(CustomerEntity.builder()
                        .nom("toto")
                        .prenom("prenomtiti")
                        .adresse(Adresse.builder().build())
                        .build())
                .deliveryManEntity(DeliveryManEntity.builder().build())
                .build();

        // when
        OrderEntity receiveOrder = createOrderDomainService.receiveOrder(order);

        // then
        OrderEntity orderEntity = orderRepositoryStub.getById("afd0e3b4-0b3b-0000-8b3b-0b3b4b3b0b3b").get();
        assertEquals(UUID.fromString("afd0e3b4-0b3b-0000-8b3b-0b3b4b3b0b3b"), orderEntity.getId());
        assertEquals(Status.AVAILABLE, receiveOrder.getStatus());
    }

}
