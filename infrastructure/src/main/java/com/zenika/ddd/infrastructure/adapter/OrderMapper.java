package com.zenika.ddd.infrastructure.adapter;

import com.zenika.ddd.commande.ConsumerEntity;
import com.zenika.ddd.commande.OrderEntity;
import com.zenika.ddd.shared.Adresse;
import com.zenika.ddd.infrastructure.entity.OrderJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderJpaEntity mapOrderEntityToOrderJpaEntity(OrderEntity orderEntity) {
        return OrderJpaEntity.builder()
                .id(orderEntity.getId())
                .dateCommande(orderEntity.getDateCommande())
                .build();
    }

    public OrderEntity mapOrderJpaEntityToOrderEntity(OrderJpaEntity orderJpaEntity) {
        Adresse adresse = Adresse.builder()
                .numero(orderJpaEntity.getConsumerAddress())
                .build();

        return OrderEntity.builder()
                .id(orderJpaEntity.getId())
                .consumerEntity(ConsumerEntity.builder()
                        .nom(orderJpaEntity.getConsumerName() == null ? "nom" : orderJpaEntity.getConsumerName())
                        .prenom(orderJpaEntity.getConsumerFirstName() == null ? "prenom" : orderJpaEntity.getConsumerFirstName())
                        .adresse(adresse)
                        .build())
                .dateCommande(orderJpaEntity.getDateCommande())
                .build();
    }
}
