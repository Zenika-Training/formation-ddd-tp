package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.course.DeliveryManEntity;
import com.zenika.ddd.mvc.dto.CommandeMessageDto;
import com.zenika.ddd.order.ClientEntity;
import com.zenika.ddd.order.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommandeMapper {
    public OrderEntity mapCommandeMessageDtoToCommandeEntity(CommandeMessageDto commandeMessageDto) {
        return OrderEntity.builder()
                .id(UUID.randomUUID())
                .clientEntity(ClientEntity.builder().build())
                .deliveryManEntity(DeliveryManEntity.builder().build())
                .build();
    }
}
