package com.zenika.ddd.order;

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
public class OrderEntity {

    private UUID id;
    private ClientEntity clientEntity;
    private DeliveryManEntity deliveryManEntity;
    private LocalDateTime dateCommande;
    private List<ItemVO> itemVOList;
    @Builder.Default
    private OrderStatus orderStatus = OrderStatus.AVAILABLE;

    public void accept() {
        this.orderStatus = OrderStatus.ACCEPTED;
    }

    public void affectDeliveryMan(DeliveryManEntity deliveryMan) {
        this.deliveryManEntity = deliveryMan;
    }
}
