package com.zenika.ddd.mvc.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public class CommandeDisponibleDto {

    private UUID id;
    private ClientDto client;
    private Long distance;
    private Boolean accepted;
}
