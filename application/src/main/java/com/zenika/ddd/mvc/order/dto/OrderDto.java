package com.zenika.ddd.mvc.order.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class OrderDto {
    private String id;
    private LocalDateTime dateCommande;
    private String consommateurId;
    private List<PlatDto> plats;
}
