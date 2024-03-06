package com.zenika.ddd.aggregateorder.out;

import com.zenika.ddd.aggregateorder.Order;

import java.util.List;

public interface OrderRepository {

    Order getOrder(Order.OrderVoId orderId);

    List<Order> getOrders();
}
