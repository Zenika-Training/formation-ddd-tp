package com.zenika.ddd.commande;

import com.zenika.ddd.doc.DomainObject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@DomainObject
public class OrderEntity {

    private UUID id;
    private ConsumerEntity consumerEntity;
    private LocalDateTime dateCommande;
    private List<ItemVO> itemVOList;

}
