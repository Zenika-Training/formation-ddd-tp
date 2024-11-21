package com.zenika.ddd.order;

import com.zenika.ddd.doc.DomainService;
import lombok.NonNull;

@DomainService
public class CreateOrderDomainService {

    public OrderEntity receiveOrder(@NonNull OrderEntity order) {

        // Guard
        if (!order.getOrderStatus().equals(OrderStatus.AVAILABLE)) {
            throw new RuntimeException();
        }

        return null;
    }
}
