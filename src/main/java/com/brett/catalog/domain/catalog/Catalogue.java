package com.brett.catalog.domain.catalog;

import com.brett.DomainService;
import com.brett.catalog.domain.prix.PrixVeloRepository;
import com.brett.catalog.domain.velo.ModeleVeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DomainService
@Service
public class Catalogue {
    @Autowired
    ModeleVeloRepository modeleVeloRepository;
    @Autowired
    PrixVeloRepository prixVeloRepository;

    public List<VeloAndPrix> getVelosCatalogue() {
        var modeles = modeleVeloRepository.findAllModelesDeVelo();
        return modeles.stream().map(modele -> {
            var prix = prixVeloRepository.getPrixVelo(modele.getCodeModele());
            return new VeloAndPrix(modele, prix);
        }).toList();
    }
}
