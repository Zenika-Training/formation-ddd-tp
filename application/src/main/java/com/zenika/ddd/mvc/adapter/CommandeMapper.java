package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.commande.OrderEntity;
import com.zenika.ddd.mvc.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CommandeMapper {

    private final ProduitMapper produitMapper;

    public OrderEntity toCommandeEntity(OrderDto orderDto) {
        return OrderEntity.builder()
                          .id(orderDto.getId())
                          .dateCommande(orderDto.getDateCreation())
                          .itemVOList(ProduitMapper.toItemVOList(orderDto.getProduits()))
                          .build();
    }

    public OrderDto toOrderDto(OrderEntity orderEntity) {
        return OrderDto.builder()
                       .id(orderEntity.getId().toString())
                       .dateCreation(orderEntity.getDateCommande())
                       .produits(produitMapper.toProduitVOList(orderEntity.getItemVOList()))
                       .build();
    }
}
