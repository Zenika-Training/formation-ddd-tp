package com.zenika.ddd.domain;

import com.zenika.ddd.doc.DomainService;
import com.zenika.ddd.domain.depot.DepotPieceJustificativeEntity;
import com.zenika.ddd.port.PieceDeposeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@DomainService
public class RechercherToutesLesPiecesDeposeesDUnApprenantService {

    private final PieceDeposeeRepository pieceDeposeeRepository;

    public List<DepotPieceJustificativeEntity> rechercherDepotParAprenantEtFormation(UUID apprenant, UUID formationId) {
        return pieceDeposeeRepository.findAllByApprenantIdAndFormationId(apprenant, formationId);
    }

    public List<DepotPieceJustificativeEntity> rechercherDepotParAprenant(UUID apprenant) {
        return pieceDeposeeRepository.findAllByApprenantUuid(apprenant);
    }
}
