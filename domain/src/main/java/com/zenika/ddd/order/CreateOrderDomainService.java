package com.zenika.ddd.order;

import com.zenika.ddd.doc.DomainService;
import lombok.NonNull;

@DomainService
public class CreateOrderDomainService {

    public OrderEntity receiveOrder(@NonNull OrderEntity order) {

        // Guard
        if (!order.getStatus().equals(Status.AVAILABLE)) {
            throw new RuntimeException();
        }

        if (order.getClientEntity() == null)
            throw new IllegalArgumentException("client entity should not be null");

        if (order.getDeliveryManEntity() == null)
            throw new IllegalArgumentException("deliveryman entity should not be null");

        if (order.getId() == null)
            throw new IllegalArgumentException("deliveryman entity should not be null");

        return order;
    }
}
