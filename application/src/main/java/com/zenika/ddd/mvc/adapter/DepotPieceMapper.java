package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.domain.depot.DepotPieceJustificativeEntity;
import com.zenika.ddd.mvc.dto.PieceDeposeeDto;
import com.zenika.ddd.mvc.dto.ValiderDepotPiecesByApprenantResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepotPieceMapper {

    public ValiderDepotPiecesByApprenantResponseDto toValiderDepotPiecesByApprenantResponseDto(List<DepotPieceJustificativeEntity> depotPieceJustificativeEntities) {
        List<PieceDeposeeDto> pieceDeposeeDtos = depotPieceJustificativeEntities.stream().map(this::map).toList();
        return ValiderDepotPiecesByApprenantResponseDto.builder()
                .uuidApprenant(depotPieceJustificativeEntities.get(0).getId().id())
                .pieceDeposeeDtos(pieceDeposeeDtos)
                .build();
    }


    private PieceDeposeeDto map(DepotPieceJustificativeEntity depotPieceJustificativeEntity) {
        return PieceDeposeeDto.builder()
                .id(depotPieceJustificativeEntity.getId().id())
                .statut(depotPieceJustificativeEntity.getStatutDepot().toString())
                .build();
    }
}
