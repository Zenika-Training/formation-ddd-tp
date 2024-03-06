package com.brett.catalog.application;

import com.brett.ApplicationService;
import com.brett.EventBus;
import com.brett.catalog.domain.velo.ModeleDeVelo;
import com.brett.catalog.domain.vente.LieuDePickup;
import com.brett.catalog.domain.vente.TypeLieuDePickup;
import com.brett.catalog.domain.vente.NouvelleDemandeLocationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@ApplicationService
@Service
public class DemandeDeLocation {

    @Autowired
    EventBus eventBus;

    @Transactional
    public void handleDemandeLocation(LieuDePickup lieuDePickup, LocalDate dateDebut, LocalDate dateFin, List<ModeleDeVelo> velos) {
        // aller chercher le prix par jour des velos
        // enregistrer la demande de location en cours

        // send event
        var event = new NouvelleDemandeLocationEvent(
                UUID.randomUUID(),
                LocalDate.now(),
                NouvelleDemandeLocationEvent.class.getName(),
                lieuDePickup,
                dateDebut,
                dateFin,
                velos
        );
        eventBus.sendEvent(event);
    }

}
