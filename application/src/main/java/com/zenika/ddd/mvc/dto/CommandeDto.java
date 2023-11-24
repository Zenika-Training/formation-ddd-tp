package com.zenika.ddd.mvc.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CommandeDto {
    private String id;
    private LocalDateTime dateCommande;
    private String consommateurId;
    private List<PlatDto> plats;
}
