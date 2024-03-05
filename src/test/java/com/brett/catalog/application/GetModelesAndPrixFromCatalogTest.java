package com.brett.catalog.application;

import com.brett.catalog.domain.Fixtures;
import com.brett.catalog.domain.prix.PrixVelo;
import com.brett.catalog.domain.prix.PrixVeloRepository;
import com.brett.catalog.domain.velo.ModeleVeloRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetModelesAndPrixFromCatalogTest {

    @Autowired
    ModeleVeloRepository modeleVeloRepository;

    @Autowired
    PrixVeloRepository prixVeloRepository;

    @Autowired
    GetModelesAndPrixFromCatalog getModelesAndPrixFromCatalog;

    @Test
    public void canGetModelesAndPrix() {
        var veloBmx = Fixtures.veloBmx();
        var veloDecathlon = Fixtures.veloDecathlon();
        modeleVeloRepository.addModele(veloBmx);
        modeleVeloRepository.addModele(veloDecathlon);

        var prixBmx = new PrixVelo(veloBmx.getCodeModele(), Fixtures.euros45ParJour);
        var prixDecathlon = new PrixVelo(veloDecathlon.getCodeModele(), Fixtures.euros55ParJour);
        prixVeloRepository.addPrix(prixBmx);
        prixVeloRepository.addPrix(prixDecathlon);

        var modelesAndPrix = getModelesAndPrixFromCatalog.getVelosAndPrix();
        assertFalse(modelesAndPrix.isEmpty());
    }

}