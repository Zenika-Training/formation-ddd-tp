package com.zenika.ddd.subdomainrestaurant.out;

import com.zenika.ddd.subdomainrestaurant.Order;

import java.util.List;

public interface OrderRepository {

    Order getOrder(Order.OrderVoId orderId);

    List<Order> getOrders();
}
