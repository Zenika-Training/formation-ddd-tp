package com.zenika.ddd.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BonDeCommande {
    String id;
    CommandeDTO commande;
}
