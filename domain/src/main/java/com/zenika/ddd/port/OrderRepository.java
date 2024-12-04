package com.zenika.ddd.port;

import com.zenika.ddd.order.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    List<OrderEntity> getAll();

    Optional<OrderEntity> getById(String id);

    OrderEntity save(OrderEntity orderEntity);
}
