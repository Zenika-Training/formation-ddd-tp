package com.macif.ddd.brett.catalogue.domain;

import com.macif.ddd.brett.DomainService;
import com.macif.ddd.brett.catalogue.domain.model.Modele;
import com.macif.ddd.brett.catalogue.domain.repository.ModeleRepository;

import java.util.List;
import java.util.UUID;

@DomainService
public class Catalogue {

    private final ModeleRepository modeleRepository;

    public Catalogue(ModeleRepository modeleRepository) {
        this.modeleRepository = modeleRepository;
    }

    public void ajouterUnModele(Modele modele) {
        var modeles = modeleRepository.listerModele();

        if (modele.getId() == null) {
            modele.setId(UUID.randomUUID());
        }

        if (!modeles.contains(modele)) {
            modeleRepository.ajouterModele(modele);
        }
    }

    public void retirerModele(UUID modeleId) {
        modeleRepository.retirerModele(modeleId);
    }

    public List<Modele> listerModeles() {
        return modeleRepository.listerModele();
    }
}
