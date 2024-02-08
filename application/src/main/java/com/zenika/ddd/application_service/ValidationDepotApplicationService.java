package com.zenika.ddd.application_service;

import com.zenika.ddd.domain.RechercherToutesLesPiecesDeposeesDUnApprenantService;
import com.zenika.ddd.domain.depot.DepotPieceJustificativeEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ValidationDepotApplicationService {

    private final RechercherToutesLesPiecesDeposeesDUnApprenantService rechercheDomainService;

    public List<Depot> accepterTousLesDepotsParApprenantEtInscription(UUID apprenantId, UUID formationId) {
        return rechercheDomainService.rechercherDepotParAprenantEtFormation(apprenantId, formationId)
                .stream()
                .map(depotPiece -> {
                    depotPiece.accepterPieceJustificative();
                    return depotPiece;
                })
                .toList();
    }

    public void refuserTousLesDepotsParApprenantEtInscription(UUID apprenantId, UUID formationId) {
        rechercheDomainService.rechercherDepotParAprenantEtFormation(apprenantId, formationId)
                .forEach(DepotPieceJustificativeEntity::refuserPieceJustificative);
    }
}
