package com.zenika.ddd.repository;

import com.zenika.ddd.adapter.mapper.DepotPieceJustificativeEntityMapper;
import com.zenika.ddd.domain.depot.DepotPieceJustificativeEntity;
import com.zenika.ddd.entity.DepotPieceJustificativeJpaEntity;
import com.zenika.ddd.port.PieceDeposeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Primary
@RequiredArgsConstructor
public class PieceDeposeeRepositoryImpl implements PieceDeposeeRepository {

    private final DepotPiecesRepository depotPiecesRepository;
    private final DepotPieceJustificativeEntityMapper depotPieceJustificativeEntityMapper;

    @Override
    public List<DepotPieceJustificativeEntity> findAllByApprenantIdAndFormationId(UUID apprenantId, UUID formationId) {
        return depotPieceJustificativeEntityMapper.convertToDomainEntity(depotPiecesRepository.findAllByApprenant(apprenantId), this);
    }

    @Override
    public List<DepotPieceJustificativeEntity> findAllByApprenantUuid(UUID apprenantId) {
        List<DepotPieceJustificativeJpaEntity> allByApprenant = depotPiecesRepository.findAllByApprenant(apprenantId);
        return depotPieceJustificativeEntityMapper.convertToDomainEntity(allByApprenant, this);
    }

    @Override
    public DepotPieceJustificativeEntity enregistrer(DepotPieceJustificativeEntity entity) {
        DepotPieceJustificativeJpaEntity savedJpaEntity = depotPiecesRepository.save(depotPieceJustificativeEntityMapper.convertToJpaEntity(entity));
        return depotPieceJustificativeEntityMapper.convertToDomainEntity(savedJpaEntity, this);
    }
}
