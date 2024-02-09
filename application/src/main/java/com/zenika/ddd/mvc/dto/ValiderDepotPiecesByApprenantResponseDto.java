package com.zenika.ddd.mvc.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Builder
@Data
public class ValiderDepotPiecesByApprenantResponseDto {

    private UUID uuidApprenant;
    private List<PieceDeposeeDto> pieceDeposeeDtos;
}
