package com.zenika.ddd.mvc.controller;

import com.zenika.ddd.mvc.adapter.CommandeMapper;
import com.zenika.ddd.mvc.dto.CommandeMessageDto;
import com.zenika.ddd.order.CreateOrderDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/recevoir-commande")
@RequiredArgsConstructor
public class RecevoirCommandeController {

    private final CommandeMapper commandeMapper;
    private final CreateOrderDomainService createOderDomainService;

    @PostMapping("/recevoir")
    public ResponseEntity recevoirCommande(CommandeMessageDto commandeMessageDto) {

        createOderDomainService.receiveOrder(commandeMapper.mapCommandeMessageDtoToCommandeEntity(commandeMessageDto));

        return ResponseEntity.ok().build();
    }
}
