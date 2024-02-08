package com.zenika.ddd.port;

import com.zenika.ddd.domain.depot.DepotPieceJustificativeEntity;

import java.util.List;
import java.util.UUID;

public interface PieceDeposeeRepository {

    List<DepotPieceJustificativeEntity> findAllByApprenantIdAndFormationId(UUID apprenantId, UUID formationId);

    List<DepotPieceJustificativeEntity> findAllByApprenantUuid(UUID apprenantId);

    DepotPieceJustificativeEntity enregistrer(DepotPieceJustificativeEntity entity);
}
