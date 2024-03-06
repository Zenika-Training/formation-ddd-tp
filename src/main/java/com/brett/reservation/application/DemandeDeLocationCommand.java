package com.brett.reservation.application;

import com.brett.reservation.domain.CodeLieuDePickup;
import com.brett.reservation.domain.ModeleDeVelo;

import java.time.LocalDate;
import java.util.List;

public record DemandeDeLocationCommand(
        CodeLieuDePickup codeLieuDePickup,
        LocalDate dateDebut,
        LocalDate dateFin,
        List<ModeleDeVelo> modeleDeVelo
) {
}
