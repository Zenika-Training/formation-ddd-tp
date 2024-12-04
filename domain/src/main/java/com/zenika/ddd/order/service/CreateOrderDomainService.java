package com.zenika.ddd.order.service;

import com.zenika.ddd.doc.DomainService;
import com.zenika.ddd.order.OrderEntity;
import com.zenika.ddd.port.OrderRepository;
import com.zenika.ddd.shared.BusinessException;
import com.zenika.ddd.shared.OrderStatus;

import java.util.Optional;

@DomainService
public class CreateOrderDomainService {

    private final OrderRepository orderRepository;

    public CreateOrderDomainService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntity receiveOrder(OrderEntity order) {

        // Guards

        Optional<OrderEntity> orderEntityInDB = orderRepository.getById(order.getId().toString());
        if (orderEntityInDB.isEmpty()) {
            return orderRepository.save(order);
        } else {
            return order;
        }
    }
}
