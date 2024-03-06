package com.brett.reservation.infrastructure.acl.catalog;

import com.brett.catalog.domain.vente.NouvelleDemandeLocationEvent;
import com.brett.reservation.application.DemandeDeLocationCommand;
import com.brett.reservation.domain.CodeLieuDePickup;
import com.brett.reservation.domain.ModeleDeVelo;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public DemandeDeLocationCommand map(NouvelleDemandeLocationEvent event) {
        return new DemandeDeLocationCommand(
                new CodeLieuDePickup(event.lieuDePickup().codeLieuPickup()),
                event.dateDebut(),
                event.dateFin(),
                event.velos().stream()
                        .map(velo -> new ModeleDeVelo(velo.getCodeModele().modele()))
                        .toList()
        );
    }

}
