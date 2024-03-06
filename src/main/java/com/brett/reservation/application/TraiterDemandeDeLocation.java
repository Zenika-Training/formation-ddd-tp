package com.brett.reservation.application;

import com.brett.ApplicationService;
import com.brett.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@ApplicationService
@Service
public class TraiterDemandeDeLocation {

    @Autowired
    EventBus eventBus;

    Logger logger = LoggerFactory.getLogger(TraiterDemandeDeLocation.class);

    public void traiterDemandeDeLocation(DemandeDeLocationCommand command) {
        // traitement metier
        // envoi de l'evenement de sortie
        // eventBus.sendEvent(); // envoi VelosDisponibles
        logger.info("Contexte Reseration a recu la commande {}", command.toString());
    }

}
