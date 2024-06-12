package com.zenika.ddd.service;

import com.zenika.ddd.commande.OrderEntity;
import com.zenika.ddd.commande.SelectionnerCommandeDomainService;
import com.zenika.ddd.mvc.adapter.CommandeMapper;
import com.zenika.ddd.mvc.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateOrderApplicationService {

    private final CommandeMapper commandeMapper;
    private final SelectionnerCommandeDomainService selectionnerCommandeDomainService;

    public OrderDto createOrder(OrderDto orderDto) {

        OrderEntity commandeEntity = commandeMapper.toCommandeEntity(orderDto);

        OrderEntity orderEntity = selectionnerCommandeDomainService.ajouterCommande(commandeEntity);

        return commandeMapper.toOrderDto(orderEntity);
    }
}
