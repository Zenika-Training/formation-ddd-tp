package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.mvc.dto.CommandeMessageDto;
import com.zenika.ddd.order.model.CustomerEntity;
import com.zenika.ddd.order.model.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommandeMapper {
    public OrderEntity mapCommandeMessageDtoToCommandeEntity(CommandeMessageDto commandeMessageDto) {
        return OrderEntity.builder()
                .id(UUID.randomUUID())
                .customerEntity(CustomerEntity.builder().build())
                .build();
    }
}
