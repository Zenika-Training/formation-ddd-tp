package com.zenika.ddd.application_service;

import com.zenika.ddd.commande.CommandeEntity;
import com.zenika.ddd.commande.SelectionnerCommandeDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreationCommandeInfrastructureService {

    private final SelectionnerCommandeDomainService selectionnerCommandeDomainService;

    public void creerCommande(CommandeEntity commandeEntity) {

        // check utilisateur autorisé
        selectionnerCommandeDomainService.ajouterCommande(commandeEntity);
        selectionnerCommandeDomainService.selectionnerCommande(commandeEntity);

    }
}
