package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.commande.OrderEntity;
import com.zenika.ddd.mvc.dto.CommandeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CommandeMapper {

    private final PlatMapper platMapper;

    public OrderEntity toCommandeEntity(CommandeDTO commandeDTO) {
        return OrderEntity.builder()
                          .id(UUID.fromString(commandeDTO.getId()))
                          .dateCommande(commandeDTO.getDateCommande())
                          .itemVOList(PlatMapper.toPlatVOList(commandeDTO.getPlats()))
                          .build();
    }
}
