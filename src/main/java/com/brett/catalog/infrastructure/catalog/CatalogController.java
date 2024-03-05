package com.brett.catalog.infrastructure.catalog;

import com.brett.catalog.application.GetModelesAndPrixFromCatalog;
import com.brett.catalog.domain.catalog.VeloAndPrix;
import com.brett.catalog.domain.prix.PrixVelo;
import com.brett.catalog.domain.prix.PrixVeloRepository;
import com.brett.catalog.domain.velo.ModeleVeloRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatalogController {

    @Autowired
    GetModelesAndPrixFromCatalog getModelesAndPrixFromCatalog;

    @Autowired
    PrixVeloRepository prixVeloRepository;

    @Autowired
    ModeleVeloRepository modeleVeloRepository;

    @PostConstruct
    public void init() {
        var veloBmx = Fixtures.veloBmx();
        var veloDecathlon = Fixtures.veloDecathlon();
        modeleVeloRepository.addModele(veloBmx);
        modeleVeloRepository.addModele(veloDecathlon);

        var prixBmx = new PrixVelo(veloBmx.getCodeModele(), Fixtures.euros45ParJour);
        var prixDecathlon = new PrixVelo(veloDecathlon.getCodeModele(), Fixtures.euros55ParJour);
        prixVeloRepository.addPrix(prixBmx);
        prixVeloRepository.addPrix(prixDecathlon);
    }

    @GetMapping("/catalog")
    public List<VeloAndPrix> getModeles() {
        return getModelesAndPrixFromCatalog.getVelosAndPrix();
    }

}
