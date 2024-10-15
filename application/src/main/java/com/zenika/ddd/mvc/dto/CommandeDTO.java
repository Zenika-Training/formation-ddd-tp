package com.zenika.ddd.mvc.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder(toBuilder = true)
public class CommandeDTO {
    private String id;
    private LocalDateTime dateCommande;
    private ClientFinal clientFinal;
    private Restaurant restaurant;
    private List<PlatDto> plats;
}
