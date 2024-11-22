package com.zenika.ddd.infrastructure.updator;

import com.zenika.ddd.infrastructure.entity.OrderJpaEntity;
import com.zenika.ddd.order.model.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderEntityMapper {

    public static OrderEntity convert(OrderJpaEntity orderJpaEntity) {
        return OrderEntity.builder().id(UUID.fromString(orderJpaEntity.getId())).build();
    }

    public static OrderJpaEntity convert(OrderEntity orderEntity) {
        return OrderJpaEntity.builder().id(orderEntity.getId().toString()).build();
    }
}
