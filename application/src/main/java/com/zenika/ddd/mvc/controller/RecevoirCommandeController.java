package com.zenika.ddd.mvc.controller;

import com.zenika.ddd.mvc.adapter.CommandeMapper;
import com.zenika.ddd.mvc.dto.CommandeMessageDto;
import com.zenika.ddd.order.services.CreateOrderDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/commande")
@RequiredArgsConstructor
public class RecevoirCommandeController {

    private final CommandeMapper commandeMapper;
    private final CreateOrderDomainService createOderDomainService;

    @PostMapping("/recevoir")
    public @ResponseBody ResponseEntity recevoirCommande(@RequestBody CommandeMessageDto commandeMessageDto) {

        createOderDomainService.receiveOrder(commandeMapper.mapCommandeMessageDtoToCommandeEntity(commandeMessageDto));

        return ResponseEntity.ok().build();
    }
}
