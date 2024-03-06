package com.zenika.ddd.mvc.order.adapter;

import com.zenika.ddd.mvc.order.dto.OrderDto;
import com.zenika.ddd.mvc.order.dto.PlatDto;
import com.zenika.ddd.aggregateorder.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoMapper {

    public OrderDto mapOrderToDto(Order order) {
        return OrderDto.builder()
            .id(order.getId().id().toString())
            .plats(order.getItems().stream()
                        .map(item ->
                            PlatDto.builder()
                                   .id(item.getId().id().toString())
                                   .prix(item.getPrice())
                                   .nom(item.getName())
                                .build()
                        ).toList())
            .build();
    }

}
