package com.zenika.ddd.application_service;

import com.zenika.ddd.domain.RechercherToutesLesPiecesDeposeesDUnApprenantService;
import com.zenika.ddd.domain.depot.DepotPieceJustificativeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ValidationDepotApplicationService {

    private final RechercherToutesLesPiecesDeposeesDUnApprenantService rechercheDomainService;

    public List<DepotPieceJustificativeEntity> accepterTousLesDepotsParApprenantEtInscription(UUID apprenantId, UUID formationId) {
        return rechercheDomainService.rechercherDepotParAprenantEtFormation(apprenantId, formationId).stream()
                .map(depotPiece -> {
                    depotPiece.accepterPieceJustificative();
                    return depotPiece;
                })
                .toList();
    }

    public List<DepotPieceJustificativeEntity> refuserTousLesDepotsParApprenantEtInscription(UUID apprenantId, UUID formationId) {
        return rechercheDomainService.rechercherDepotParAprenantEtFormation(apprenantId, formationId)
                .stream()
                .map(depotPiece -> {
                    depotPiece.refuserPieceJustificative();
                    return depotPiece;
                })
                .toList();
    }
}
