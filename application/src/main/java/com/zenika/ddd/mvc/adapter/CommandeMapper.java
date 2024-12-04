package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.order.OrderEntity;
import com.zenika.ddd.mvc.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class CommandeMapper {

    private final PlatMapper platMapper;

    public CommandeMapper(PlatMapper platMapper) {
        this.platMapper = platMapper;
    }

    public OrderEntity toCommandeEntity(OrderDto orderDto) {
        return null;
    }
}
