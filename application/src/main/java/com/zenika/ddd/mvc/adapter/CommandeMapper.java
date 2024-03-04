package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.commande.OrderEntity;
import com.zenika.ddd.mvc.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CommandeMapper {

    private final PlatMapper platMapper;

    public OrderEntity toCommandeEntity(OrderDto orderDto) {
        return OrderEntity.builder()
                          .id(UUID.fromString(orderDto.getId()))
                          .dateCommande(orderDto.getDateCommande())
                          .itemVOList(PlatMapper.toPlatVOList(orderDto.getPlats()))
                          .build();
    }
}
