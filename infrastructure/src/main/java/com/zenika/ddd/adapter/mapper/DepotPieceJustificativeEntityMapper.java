package com.zenika.ddd.adapter.mapper;

import com.zenika.ddd.domain.depot.DefinitionPieceJustificativeEntity;
import com.zenika.ddd.domain.depot.DepotPieceJustificativeEntity;
import com.zenika.ddd.domain.depot.DepotVoId;
import com.zenika.ddd.domain.depot.StatutDepot;
import com.zenika.ddd.entity.DefinitionPieceJustificativeJpaEntity;
import com.zenika.ddd.entity.DepotPieceJustificativeJpaEntity;
import com.zenika.ddd.port.PieceDeposeeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DepotPieceJustificativeEntityMapper {


    public List<DepotPieceJustificativeEntity> convertToDomainEntity(List<DepotPieceJustificativeJpaEntity> depotPieceJustificativeJpaEntities, PieceDeposeeRepository pieceDeposeeRepository) {
        return depotPieceJustificativeJpaEntities.stream().map(depotPieceJustificativeJpaEntity -> this.convertToDomainEntity(depotPieceJustificativeJpaEntity, pieceDeposeeRepository)).toList();
    }

    public DepotPieceJustificativeEntity convertToDomainEntity(DepotPieceJustificativeJpaEntity depotPieceJustificativeJpaEntity, PieceDeposeeRepository pieceDeposeeRepository) {
        return new DepotPieceJustificativeEntity(
                pieceDeposeeRepository,
                new DepotVoId(UUID.fromString(depotPieceJustificativeJpaEntity.getId())),
                StatutDepot.valueOf(depotPieceJustificativeJpaEntity.getStatutDepot().name()),
                depotPieceJustificativeJpaEntity.getDateDepot(),
                depotPieceJustificativeJpaEntity.getDateExpiration(),
                "referencePieceDeposee",
                depotPieceJustificativeJpaEntity.getApprenant(),
                UUID.randomUUID(),
                convertToDomainEntity(depotPieceJustificativeJpaEntity.getDefinitionPieceJustificativeEntity()),
                false
                );
    }

    private DefinitionPieceJustificativeEntity convertToDomainEntity(DefinitionPieceJustificativeJpaEntity definitionPieceJustificativeJpaEntity) {
        return new DefinitionPieceJustificativeEntity(
                UUID.fromString(definitionPieceJustificativeJpaEntity.getId()),
                definitionPieceJustificativeJpaEntity.getLibellePiece(),
                definitionPieceJustificativeJpaEntity.getDescriptif(),
                definitionPieceJustificativeJpaEntity.getTypologie(),
                definitionPieceJustificativeJpaEntity.isTemoinReutilisable(),
                definitionPieceJustificativeJpaEntity.isTemoinSensible(),
                definitionPieceJustificativeJpaEntity.isTemoinPhoto()
        );

    }

    public DepotPieceJustificativeJpaEntity convertToJpaEntity(DepotPieceJustificativeEntity depotPieceJustificativeEntity) {
        DepotPieceJustificativeJpaEntity jpaEntity = new DepotPieceJustificativeJpaEntity();
        jpaEntity.setId(depotPieceJustificativeEntity.getId().id().toString());
        jpaEntity.setStatutDepot(com.zenika.ddd.adapter.mapper.StatutDepot.valueOf(depotPieceJustificativeEntity.getStatutDepot().name()));
        jpaEntity.setDateDepot(depotPieceJustificativeEntity.getDateDepot());
        jpaEntity.setDateExpiration(depotPieceJustificativeEntity.getDateExpiration());
        jpaEntity.setDefinitionPieceJustificativeEntity(convertToJpaEntity(depotPieceJustificativeEntity.getDefinitionPieceJustificative()));
        return jpaEntity;
    }

    public DefinitionPieceJustificativeJpaEntity convertToJpaEntity(DefinitionPieceJustificativeEntity definitionPieceJustificativeEntity) {
        DefinitionPieceJustificativeJpaEntity jpaEntity = new DefinitionPieceJustificativeJpaEntity();
        jpaEntity.setId(definitionPieceJustificativeEntity.getId().toString());
        jpaEntity.setDescriptif(definitionPieceJustificativeEntity.getDescriptif());
        jpaEntity.setTemoinPhoto(definitionPieceJustificativeEntity.isTemoinPhoto());
        jpaEntity.setTemoinSensible(definitionPieceJustificativeEntity.isTemoinSensible());
        jpaEntity.setTemoinReutilisable(definitionPieceJustificativeEntity.isTemoinReutilisable());
        jpaEntity.setTypologie(definitionPieceJustificativeEntity.getTypologie());
        jpaEntity.setLibellePiece(definitionPieceJustificativeEntity.getLibellePiece());
        return jpaEntity;
    }
}
