package com.zenika.ddd.commande;

import lombok.Builder;

import java.util.UUID;

@Builder(toBuilder = true)
public class BonDeCommandeEntity {
    UUID id;
    OrderEntity commande;
}
