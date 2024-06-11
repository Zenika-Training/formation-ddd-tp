package com.zenika.ddd.commande;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class OrderEntity {

    private String id;
    private ConsumerEntity consumerEntity;
    private LocalDateTime dateCommande;
    private List<ItemVO> itemVOList;

    @Builder.Default
    private OrderStatus orderStatus = OrderStatus.CREATED;

    public void pay() {

        if (this.orderStatus != OrderStatus.CREATED) {
            throw new IllegalStateException("Order shoyld be in CREATED status to be payed.");
        }

        if (this.orderStatus == OrderStatus.PAYED) {
            throw new IllegalStateException("Order is already payed");
        }


        this.orderStatus = OrderStatus.PAYED;
    }
}
