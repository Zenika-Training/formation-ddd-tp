package com.zenika.ddd.subdomaindelivery.order;

import com.zenika.ddd.subdomaindelivery.deliveryman.DeliveryEntity;
import com.zenika.ddd.doc.DomainService;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@DomainService
@NoArgsConstructor
public class SelectionnerCommandeDomainService {

    private final List<OrderEntity> commandes = new ArrayList<>();

    public void ajouterCommande(OrderEntity commande) {
        commandes.add(commande);
    }

    public DeliveryEntity selectionnerCommande(OrderEntity commande) {

        DeliveryEntity course = DeliveryEntity.builder()
                                              .commandeId(commande.getId())
                                              .build();

        return course;
    }
}
