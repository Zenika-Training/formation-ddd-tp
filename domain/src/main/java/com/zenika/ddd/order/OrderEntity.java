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
    private LocalDateTime dateCommande;
    private List<ItemVO> itemVOList;
    private OrderStatus orderStatus = OrderStatus.AVAILABLE;

    public void accept() {
        this.orderStatus = OrderStatus.ACCEPTED;
    }
}
