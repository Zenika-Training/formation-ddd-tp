package com.zenika.ddd.infrastructure.repository;

import com.zenika.ddd.aggregateorder.Order;
import com.zenika.ddd.aggregateorder.out.OrderRepository;
import com.zenika.ddd.infrastructure.adapter.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderSpringRepository orderSpringRepository;
    private final OrderMapper orderMapper;

    @Override
    public Order getOrder(Order.OrderVoId orderId) {
        return orderMapper.map(orderSpringRepository.findById(orderId.id()).orElseThrow());
    }

    @Override
    public List<Order> getOrders() {
        return orderMapper.map(orderSpringRepository.findAll());
    }
}
