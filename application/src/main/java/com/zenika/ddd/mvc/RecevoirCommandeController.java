package com.zenika.ddd.mvc;

import com.zenika.ddd.mvc.adapter.CommandeMapper;
import com.zenika.ddd.mvc.dto.CommandeMessageDto;
import com.zenika.ddd.order.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/recevoir-commande")
@RequiredArgsConstructor
public class RecevoirCommandeController {

    private final CommandeMapper commandeMapper;

    @PostMapping("/recevoir")
    public ResponseEntity recevoirCommande(CommandeMessageDto commandeMessageDto) {

        OrderEntity orderEntity = commandeMapper.mapCommandeMessageDtoToCommandeEntity(commandeMessageDto);

        return ResponseEntity.ok().build();
    }
}
