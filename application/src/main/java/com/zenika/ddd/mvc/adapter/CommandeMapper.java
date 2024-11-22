package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.mvc.dto.CommandeMessageDto;
import com.zenika.ddd.order.model.CustomerEntity;
import com.zenika.ddd.order.model.OrderEntity;
import com.zenika.ddd.shared.Adresse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommandeMapper {
    public OrderEntity mapCommandeMessageDtoToCommandeEntity(CommandeMessageDto commandeMessageDto) {
        return OrderEntity.builder()
                .id(UUID.randomUUID())
                .customerEntity(CustomerEntity.builder()
                        .nom(commandeMessageDto.getClientDto().getClientName())
                        .prenom(commandeMessageDto.getClientDto().getClientPrenom())
                        .adresse(Adresse.builder()
                                .rue(commandeMessageDto.getClientDto().getClientAdresse())
                                .build())
                        .build())
                .build();
    }
}
