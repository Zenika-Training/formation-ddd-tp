package com.zenika.ddd.stub;

import com.zenika.ddd.doc.Stub;
import com.zenika.ddd.domain.depot.DefinitionPieceJustificativeEntity;
import com.zenika.ddd.domain.depot.DepotPieceJustificativeEntity;
import com.zenika.ddd.domain.depot.DepotVoId;
import com.zenika.ddd.domain.depot.StatutDepot;
import com.zenika.ddd.port.PieceDeposeeRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Stub
public class DepotPieceJustificativeByApprenantStub implements PieceDeposeeRepository {

    private final PieceDeposeeRepository pieceDeposeeRepository;
    private Map<DepotVoId, DepotPieceJustificativeEntity> database = new HashMap<>();

    DepotPieceJustificativeByApprenantStub(PieceDeposeeRepository pieceDeposeeRepository) {
        this.pieceDeposeeRepository = pieceDeposeeRepository;
    }

    @Override
    public List<DepotPieceJustificativeEntity> findAllByApprenantIdAndFormationId(UUID apprenantId, UUID formationId) {
        return List.of(
                new DepotPieceJustificativeEntity(
                        pieceDeposeeRepository,
                        new DepotVoId(UUID.randomUUID()),
                        StatutDepot.DEPOSE,
                        LocalDate.now(),
                        LocalDate.now(),
                        "referencePieceDeposee",
                        apprenantId,
                        UUID.randomUUID(),
                        getCarteIdentiteDefinitionStub(),
                        false
                ),
                new DepotPieceJustificativeEntity(
                        pieceDeposeeRepository,
                        new DepotVoId(UUID.randomUUID()),
                        StatutDepot.DEPOSE,
                        LocalDate.now(),
                        LocalDate.now(),
                        "referencePieceDeposee2",
                        apprenantId,
                        UUID.randomUUID(),
                        getPhotoIdentiteDefinitionStub(),
                        false
                ));    }

    @Override
    public List<DepotPieceJustificativeEntity> findAllByApprenantUuid(UUID apprenantUuid) {
        return List.of(
                new DepotPieceJustificativeEntity(
                        pieceDeposeeRepository,
                        new DepotVoId(UUID.randomUUID()),
                        StatutDepot.DEPOSE,
                        LocalDate.now(),
                        LocalDate.now(),
                        "referencePieceDeposee",
                        apprenantUuid,
                        UUID.randomUUID(),
                        getCarteIdentiteDefinitionStub(),
                        false
                        ),
                new DepotPieceJustificativeEntity(
                        pieceDeposeeRepository,
                        new DepotVoId(UUID.randomUUID()),
                        StatutDepot.DEPOSE,
                        LocalDate.now(),
                        LocalDate.now(),
                        "referencePieceDeposee2",
                        apprenantUuid,
                        UUID.randomUUID(),
                        getPhotoIdentiteDefinitionStub(),
                        false
                ));
    }

    private DefinitionPieceJustificativeEntity getCarteIdentiteDefinitionStub() {
        return new DefinitionPieceJustificativeEntity(
                UUID.randomUUID(),
                "Carte d'identité",
                "", "Pièce d'identité nationale",
                true,
                true,
                false);
    }

    private DefinitionPieceJustificativeEntity getPhotoIdentiteDefinitionStub() {
        return new DefinitionPieceJustificativeEntity(
                UUID.randomUUID(),
                "Photo d'identité",
                "", "Photo d'identité conforme",
                true,
                true,
                true);
    }


    public DepotPieceJustificativeEntity enregistrer(DepotPieceJustificativeEntity entity) {
        database.put(entity.getId(), entity);
        return entity;
    }
}


