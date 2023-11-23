package com.zenika.ddd.domain.commande;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class CommandeEntity {

    private UUID id;
    private ConsommateurEntity consommateurEntity;
    private LocalDateTime dateCommande;
    private List<PlatVO> platVOList;

}
