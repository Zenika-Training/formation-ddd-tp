package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.commande.BonDeCommandeEntity;
import com.zenika.ddd.mvc.dto.BonDeCommandeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BonDeCommandeMapper {

    public final CommandeMapper commandeMapper;

    public BonDeCommandeEntity mapBonDeCommandeDTOToBonDeCommandeEntity(BonDeCommandeDTO bonDeCommandeDTO) {
        return BonDeCommandeEntity.builder()
                .id(UUID.fromString(bonDeCommandeDTO.getId()))
                .commande(commandeMapper.toCommandeEntity(bonDeCommandeDTO.getCommandeDTO()))
                .build();

    }
}
