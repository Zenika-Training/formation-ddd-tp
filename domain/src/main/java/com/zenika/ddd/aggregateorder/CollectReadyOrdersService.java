package com.zenika.ddd.aggregateorder;

import com.zenika.ddd.doc.DomainService;
import com.zenika.ddd.aggregatedelivery.DeliveryManEntity;
import com.zenika.ddd.aggregatedelivery.RestaurantEntity;

@DomainService
public class CollectReadyOrdersService {

    public void CollectOrder(Order order, DeliveryManEntity deliveryMan, RestaurantEntity restaurant)
        throws OrderNotReadyException, DeliveryManTooFarException {

        // On order is received
        if (!order.isCompleted()) {
            throw new OrderNotReadyException(order);
        }
        // A delivery man approaches the restaurant
        if(!deliveryMan.getPosition().isCloseToPosition(restaurant.getPosition(), 1f)){
            throw new DeliveryManTooFarException();
        }

        // The delivery should collect the order when the order is ready
        order.collect();
    }

}
