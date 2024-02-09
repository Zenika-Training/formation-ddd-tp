package com.zenika.ddd.repository;

import com.zenika.ddd.entity.DepotPieceJustificativeJpaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DepotPiecesRepository extends CrudRepository<DepotPieceJustificativeJpaEntity, UUID> {

    List<DepotPieceJustificativeJpaEntity> findAllByApprenant(UUID apprenantId);
}
