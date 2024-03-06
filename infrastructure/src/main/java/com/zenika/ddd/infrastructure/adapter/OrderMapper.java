package com.zenika.ddd.infrastructure.adapter;

import com.zenika.ddd.aggregateorder.Order;
import com.zenika.ddd.infrastructure.entity.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ItemMapper itemMapper;



    public Order map(OrderEntity orderEntity) {
        return Order.builder()
                    .id(new Order.OrderVoId(UUID.fromString(orderEntity.getId())))
                    .status(orderEntity.getStatus())
                    .items(orderEntity.getItems().stream().map(itemMapper::map).toList())
                    .build();
    }



    public List<Order> map(List<OrderEntity> orderEntityList) {
        return orderEntityList.stream().map(this::map).toList();
    }
}
