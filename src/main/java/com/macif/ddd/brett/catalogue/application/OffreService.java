package com.macif.ddd.brett.catalogue.application;

import com.macif.ddd.brett.ApplicationService;
import com.macif.ddd.brett.catalogue.domain.OffreAjoute;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@ApplicationService
public class OffreService {

    @EventListener
    public void offreAjoute(OffreAjoute o) {

    }

}
