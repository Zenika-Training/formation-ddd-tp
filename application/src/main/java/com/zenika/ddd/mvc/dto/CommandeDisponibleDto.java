package com.zenika.ddd.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommandeDisponibleDto {

    private UUID id;
    private ClientDto client;
    private Long distance;
    private Boolean accepted;
}
