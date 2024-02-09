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

    private Map<DepotVoId, DepotPieceJustificativeEntity> database = new HashMap<>();

    public DepotPieceJustificativeByApprenantStub() {
        UUID apprenantUuid = UUID.fromString("ad2fbf1c-f7b7-4c44-ba7b-5da5247ee868");
        database.put(
                new DepotVoId(UUID.randomUUID()),
                new DepotPieceJustificativeEntity(
                        this,
                        new DepotVoId(UUID.randomUUID()),
                        StatutDepot.DEPOSE,
                        LocalDate.now(),
                        LocalDate.now(),
                        "referencePieceDeposee",
                        apprenantUuid,
                        UUID.randomUUID(),
                        getCarteIdentiteDefinitionStub(),
                        false
                )
        );
        database.put(
                new DepotVoId(UUID.randomUUID()),
                new DepotPieceJustificativeEntity(
                        this,
                        new DepotVoId(UUID.randomUUID()),
                        StatutDepot.DEPOSE,
                        LocalDate.now(),
                        LocalDate.now(),
                        "referencePieceDeposee2",
                        apprenantUuid,
                        UUID.randomUUID(),
                        getPhotoIdentiteDefinitionStub(),
                        false
                )
        );
    }

    @Override
    public List<DepotPieceJustificativeEntity> findAllByApprenantIdAndFormationId(UUID apprenantId, UUID formationId) {
        return database.values().stream()
                .filter(depotPieceJustificativeEntity -> depotPieceJustificativeEntity.getApprenant().equals(apprenantId))
                .toList();
    }

    @Override
    public List<DepotPieceJustificativeEntity> findAllByApprenantUuid(UUID apprenantId) {
        return database.values().stream()
                .filter(depotPieceJustificativeEntity -> depotPieceJustificativeEntity.getApprenant().equals(apprenantId))
                .toList();
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


