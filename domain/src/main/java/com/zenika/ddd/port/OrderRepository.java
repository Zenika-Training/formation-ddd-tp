package com.zenika.ddd.port;

import com.zenika.ddd.order.OrderEntity;

import java.util.List;

public interface OrderRepository {

    List<OrderEntity> getAll();

    OrderEntity getById(String id);

    OrderEntity save(OrderEntity orderEntity);
}
