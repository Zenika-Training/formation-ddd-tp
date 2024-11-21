package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.mvc.dto.CommandeDisponibleDto;
import com.zenika.ddd.order.OrderEntity;
import com.zenika.ddd.order.Status;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class CommandeDisponiblesMapper {

    public CommandeDisponibleDto mapOrderEntityToCommandeDisponibleDto(OrderEntity orderEntity) {
        return CommandeDisponibleDto.builder()
                .id(orderEntity.getId())
                .accepted(orderEntity.getStatus().equals(Status.ACCEPTED))
                .build();
    }
}
