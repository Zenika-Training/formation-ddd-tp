package com.zenika.ddd.subdomainrestaurant;

import com.zenika.ddd.doc.DomainService;
import com.zenika.ddd.subdomainrestaurant.out.OrderRepository;

import java.util.List;

@DomainService
public class GetOrderDomainService {

    private final OrderRepository orderRepository;

    public GetOrderDomainService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrder(Order.OrderVoId orderId) {
        return orderRepository.getOrder(orderId);
    }

    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }

}
