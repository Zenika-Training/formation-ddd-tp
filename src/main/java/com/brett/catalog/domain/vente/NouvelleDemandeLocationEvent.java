package com.brett.catalog.domain.vente;

import com.brett.DomainEvent;
import com.brett.Event;
import com.brett.catalog.domain.velo.ModeleDeVelo;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@DomainEvent
public record NouvelleDemandeLocationEvent(UUID id, LocalDate date, String eventType,
                                           LieuDePickup lieuDePickup,
                                           LocalDate dateDebut,
                                           LocalDate dateFin,
                                           List<ModeleDeVelo> velos) implements Event {
}
