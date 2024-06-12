package com.macif.ddd.brett.catalogue.infrastructure.inmemory;

import com.macif.ddd.brett.catalogue.domain.model.Modele;
import com.macif.ddd.brett.catalogue.domain.repository.ModeleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class InMemoryModelRepository implements ModeleRepository {
    private List<Modele> modeles = new ArrayList<>(
            List.of(Modele.builder().id(UUID.randomUUID()).nom("foo").build())
    );

    @Override
    public List<Modele> listerModele() {
        return modeles;
    }

    @Override
    public void ajouterModele(Modele modele) {
        modeles.add(modele);
    }

    @Override
    public void retirerModele(UUID modeleId) {
        modeles = modeles.stream()
                .filter(Predicate.not(modele -> modele.getId().equals(modeleId)))
                .toList();

    }


}
