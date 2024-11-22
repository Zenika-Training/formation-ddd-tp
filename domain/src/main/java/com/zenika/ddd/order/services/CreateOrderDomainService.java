package com.zenika.ddd.order.services;

import com.zenika.ddd.doc.DomainService;
import com.zenika.ddd.order.model.OrderEntity;
import com.zenika.ddd.order.model.Status;
import com.zenika.ddd.port.OrderRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class CreateOrderDomainService {

    private final OrderRepository orderRepository;

    public OrderEntity receiveOrder(@NonNull OrderEntity order) {

        // Guard
        if (!order.getStatus().equals(Status.AVAILABLE)) {
            throw new RuntimeException();
        }

        if (order.getCustomerEntity() == null)
            throw new IllegalArgumentException("client entity should not be null");

        if (order.getId() == null)
            throw new IllegalArgumentException("deliveryman entity should not be null");

        Optional<OrderEntity> orderEntityInDB = orderRepository.getById(order.getId().toString());
        if (orderEntityInDB.isEmpty()) {
            return orderRepository.save(order);
        } else {
            return order;
        }
    }
}
