package com.macif.ddd.brett.catalogue.application;


import com.macif.ddd.brett.ApplicationService;
import com.macif.ddd.brett.catalogue.domain.Catalogue;
import com.macif.ddd.brett.catalogue.domain.OffreAjoute;
import com.macif.ddd.brett.catalogue.domain.model.Modele;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@ApplicationService
public class CatalogueService {

    private final ApplicationEventPublisher applicationEventPublisher;

    private final Catalogue catalogue;

    public CatalogueService(ApplicationEventPublisher applicationEventPublisher, Catalogue catalogue) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.catalogue = catalogue;
    }

    public List<Modele> listerModeles() {

        applicationEventPublisher.publishEvent(new OffreAjoute("VTT", 35.0));
        return catalogue.listerModeles();
    }

}
