package com.zenika.ddd.course;

import com.zenika.ddd.commande.OrderEntity;

public class DeliveryManCollectDomainService {
    public void acceptAndCollectOrder(OrderEntity order) {
DeliveryManEntity deliveryMan = order.getDeliveryMan();
        deliveryMan.moveToCollectOrder(order);
        order.collect();
    }
}
