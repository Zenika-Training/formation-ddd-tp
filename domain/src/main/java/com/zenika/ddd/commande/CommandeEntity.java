package com.zenika.ddd.commande;

import com.zenika.ddd.doc.DomainObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@DomainObject
public class CommandeEntity {

    private UUID id;
    private ConsommateurEntity consommateurEntity;
    private LocalDateTime dateCommande;
    private List<PlatVO> platVOList;

}
