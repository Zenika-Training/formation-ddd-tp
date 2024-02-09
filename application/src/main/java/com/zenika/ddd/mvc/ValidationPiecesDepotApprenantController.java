package com.zenika.ddd.mvc;

import com.zenika.ddd.application_service.ValidationDepotApplicationService;
import com.zenika.ddd.domain.depot.DepotPieceJustificativeEntity;
import com.zenika.ddd.mvc.adapter.DepotPieceMapper;
import com.zenika.ddd.mvc.dto.ValiderDepotPiecesByApprenantResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/depot")
public class ValidationPiecesDepotApprenantController {

    private final ValidationDepotApplicationService validationDepotApplicationService;
    private final DepotPieceMapper depotPieceMapper;

    @PutMapping(value = "/valider/apprenant/{apprenantId}/formation/{formationId}",
            produces = "application/json")
    public ResponseEntity<ValiderDepotPiecesByApprenantResponseDto> validerDepot(@PathVariable("apprenantId") UUID apprenantId, @PathVariable("formationId") UUID formationId) {
        List<DepotPieceJustificativeEntity> depotPieceJustificativeEntities = validationDepotApplicationService.accepterTousLesDepotsParApprenantEtInscription(apprenantId, formationId);
        return ResponseEntity.ok(depotPieceMapper.toValiderDepotPiecesByApprenantResponseDto(depotPieceJustificativeEntities));
    }
}
