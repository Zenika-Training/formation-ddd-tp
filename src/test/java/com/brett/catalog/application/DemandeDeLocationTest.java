package com.brett.catalog.application;

import com.brett.Event;
import com.brett.EventBus;
import com.brett.catalog.domain.Fixtures;
import com.brett.catalog.domain.vente.LieuDePickup;
import com.brett.catalog.domain.vente.TypeLieuDePickup;
import com.brett.catalog.domain.vente.NouvelleDemandeLocationEvent;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DemandeDeLocationTest {

    public static final class InMemoryEventBus implements EventBus {

        public List<Event> sentEvents = new ArrayList<>();

        @Override
        public void sendEvent(Event event) {
            sentEvents.add(event);
        }
    }

    @Test
    public void canSendEvents() {
        var eventBus = new InMemoryEventBus();
        var demandeDeLocation = new DemandeDeLocation();
        demandeDeLocation.eventBus = eventBus;

        demandeDeLocation.handleDemandeLocation(new LieuDePickup(TypeLieuDePickup.Borne, "Borne123"), Fixtures.fourOfMarch, Fixtures.fifthOfMarch,
                List.of(Fixtures.veloBmx(), Fixtures.veloBmx()));

        var event = eventBus.sentEvents.get(0);
        assertTrue(event instanceof NouvelleDemandeLocationEvent);
        var demande = (NouvelleDemandeLocationEvent) event;
        assertEquals(new LieuDePickup(TypeLieuDePickup.Borne, "Borne123"), demande.lieuDePickup());
    }

}