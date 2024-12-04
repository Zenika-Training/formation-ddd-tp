package com.zenika.ddd.order;

import com.zenika.ddd.course.DeliveryManEntity;
import com.zenika.ddd.order.service.CreateOrderDomainService;
import com.zenika.ddd.order.stub.OrderRepositoryStub;
import com.zenika.ddd.port.OrderRepository;
import com.zenika.ddd.shared.BusinessException;
import com.zenika.ddd.shared.OrderStatus;
import com.zenika.ddd.shared.Position;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CreateOrderDomainServiceTest {

    OrderRepository orderRepositoryStub = new OrderRepositoryStub();
    CreateOrderDomainService createOrderDomainService = new CreateOrderDomainService(orderRepositoryStub);

    @Test
    void should_throw_an_exception_if_client_is_missing() {
        // Given
        OrderEntity order = OrderEntity.builder()
                .customerEntity(null)
                .deliveryManEntity(DeliveryManEntity.builder().build())
                .build();

        // When
        assertThrows(BusinessException.class, () -> createOrderDomainService.receiveOrder(order));
    }

    @Test
    void should_throw_an_exception_if_some_uuid_are_missing() {
        // Given
        OrderEntity order = OrderEntity.builder()
                .customerEntity(new CustomerEntity(
                        "nom",
                        "prenom",
                        new Position(47.216620, -1.577638)
                ))
                .deliveryManEntity(DeliveryManEntity.builder().build())
                .status(OrderStatus.AVAILABLE)
                .build();

        // When
        assertThrows(BusinessException.class, () -> createOrderDomainService.receiveOrder(order));
    }

    @Test
    void should_throw_an_exception_if_OrderStatus_is_not_available() {
        // Given
        OrderEntity order = OrderEntity.builder()
                .id(UUID.fromString("afd0e3b4-0b3b-4b3b-8b3b-0b3b4b3b0b3b"))
                .customerEntity(new CustomerEntity(
                        "nom",
                        "prenom",
                        new Position(47.216620, -1.577638)
                ))
                .deliveryManEntity(DeliveryManEntity.builder().build())
                .status(OrderStatus.ACCEPTED)
                .build();

        // When
        assertThrows(BusinessException.class, () -> createOrderDomainService.receiveOrder(order));
    }
}
