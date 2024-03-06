package com.brett.reservation.infrastructure;

import com.brett.catalog.domain.vente.NouvelleDemandeLocationEvent;
import com.brett.reservation.application.DemandeDeLocationCommand;
import com.brett.reservation.application.TraiterDemandeDeLocation;
import com.brett.reservation.infrastructure.acl.catalog.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {

    @Autowired
    TraiterDemandeDeLocation service;

    @Autowired
    Mapper mapper;

    @EventListener
    public void handleNouvelleDemandeDeLocation(NouvelleDemandeLocationEvent nouvelleDemandeLocationEvent) {
        var command = mapper.map(nouvelleDemandeLocationEvent);
        service.traiterDemandeDeLocation(command);
    }

}
