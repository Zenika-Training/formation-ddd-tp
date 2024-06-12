package com.macif.ddd.brett.catalogue.domain;

import com.macif.ddd.brett.catalogue.domain.model.Modele;
import com.macif.ddd.brett.catalogue.domain.repository.ModeleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

class CatalogueServiceTest {

    private UUID id = UUID.randomUUID();

    @Test
    public void catalogueDoitRetournerLaListeDesModeles() {
        var catalogueService = new Catalogue(new InMemoryModeleRepository());
        var modeles = catalogueService.listerModeles();
        Assertions.assertThat(modeles).hasSize(1);
    }

    @Test
    public void catalogueNeDoitPasAjouterUnModeleExistant() {
        var catalogueService = new Catalogue(new InMemoryModeleRepository());
        var model = Modele.builder().id(id).nom("bar").build();
        catalogueService.ajouterUnModele(model);
        var modeles = catalogueService.listerModeles();
        Assertions.assertThat(modeles).hasSize(1);
    }

    @Test
    public void catalogueDoitAjouterUnModeleNonExistant() {
        var catalogueService = new Catalogue(new InMemoryModeleRepository());
        var model = Modele.builder().id(UUID.randomUUID()).nom("bar").build();
        catalogueService.ajouterUnModele(model);
        var modeles = catalogueService.listerModeles();
        Assertions.assertThat(modeles).hasSize(2);
    }





    public class InMemoryModeleRepository implements ModeleRepository {

        private List<Modele> modeles = new ArrayList<>(
                    List.of(Modele.builder().id(id).nom("foo").build())
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

}