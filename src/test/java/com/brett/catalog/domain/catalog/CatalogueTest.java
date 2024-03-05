package com.brett.catalog.domain.catalog;

import com.brett.catalog.domain.Fixtures;
import com.brett.catalog.domain.velo.InMemoryModeleVeloRepository;
import com.brett.catalog.domain.prix.InMemoryPrixVeloRepository;
import com.brett.catalog.domain.prix.PrixVelo;
import com.brett.catalog.domain.prix.PrixVeloRepository;
import com.brett.catalog.domain.velo.ModeleVeloRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatalogueTest {

    PrixVeloRepository prixVeloRepository = new InMemoryPrixVeloRepository();
    ModeleVeloRepository modeleVeloRepository = new InMemoryModeleVeloRepository();

    @Test
    public void canGetModelesDeVeloFromCatalogue() {
        Catalogue catalogue = new Catalogue();
        catalogue.prixVeloRepository = prixVeloRepository;
        catalogue.modeleVeloRepository = modeleVeloRepository;

        var veloBmx = Fixtures.veloBmx();
        var veloDecathlon = Fixtures.veloDecathlon();
        modeleVeloRepository.addModele(veloBmx);
        modeleVeloRepository.addModele(veloDecathlon);

        var prixBmx = new PrixVelo(veloBmx.getCodeModele(), Fixtures.euros45ParJour);
        var prixDecathlon = new PrixVelo(veloDecathlon.getCodeModele(), Fixtures.euros55ParJour);
        prixVeloRepository.addPrix(prixBmx);
        prixVeloRepository.addPrix(prixDecathlon);

        List<VeloAndPrix> veloAndPrixList = catalogue.getVelosCatalogue();
        assertNotNull(veloAndPrixList);
        assertEquals(2, veloAndPrixList.size());
    }


}