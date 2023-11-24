package com.zenika.ddd.mvc;

import com.zenika.ddd.application_service.CreationCommandeInfrastructureService;
import com.zenika.ddd.commande.CommandeEntity;
import com.zenika.ddd.mvc.adapter.CommandeMapper;
import com.zenika.ddd.mvc.dto.CommandeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/commande")
@RequiredArgsConstructor
public class CommandeControler {

    private final CommandeMapper commandeMapper;
    private final CreationCommandeInfrastructureService creationCommandeInfrastructureService;

    @PostMapping("/accepter")
    public void accepterCommande(@RequestBody CommandeDto commandeDto) {
        CommandeEntity commandeEntity = commandeMapper.toCommandeEntity(commandeDto);

        creationCommandeInfrastructureService.creerCommande(commandeEntity);
    }

}
