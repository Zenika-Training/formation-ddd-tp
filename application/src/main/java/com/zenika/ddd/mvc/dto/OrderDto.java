package com.zenika.ddd.mvc.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
    private String id;
    private LocalDateTime dateCommande;
    private String consommateurId;
    private List<PlatDto> plats;
}
