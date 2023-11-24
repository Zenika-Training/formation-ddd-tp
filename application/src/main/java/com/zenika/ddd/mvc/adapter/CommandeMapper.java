package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.commande.CommandeEntity;
import com.zenika.ddd.mvc.dto.CommandeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CommandeMapper {

    private final PlatMapper platMapper;

    public CommandeEntity toCommandeEntity(CommandeDto commandeDto) {
        return CommandeEntity.builder()
                .id(UUID.fromString(commandeDto.getId()))
                .dateCommande(commandeDto.getDateCommande())
                .platVOList(PlatMapper.toPlatVOList(commandeDto.getPlats()))
                .build();
    }
}
