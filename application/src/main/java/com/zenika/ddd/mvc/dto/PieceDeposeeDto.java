package com.zenika.ddd.mvc.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Builder
@Data
public class PieceDeposeeDto {
    private UUID id;
    private String statut;
}
