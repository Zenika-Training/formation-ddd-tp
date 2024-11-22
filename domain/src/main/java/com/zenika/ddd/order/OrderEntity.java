package com.zenika.ddd.order;

import com.zenika.ddd.course.RestaurantEntity;
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
    private CustomerEntity customerEntity;
    private DeliveryManEntity deliveryManEntity;
    private LocalDateTime dateCommande;
    private List<ItemVO> itemVOList;

    @Builder.Default
    private Status status = Status.AVAILABLE;
    private RestaurantEntity restaurantEntity;

    public void accept() {
        this.status = Status.ACCEPTED;
    }

    public void collect() {
        this.status = Status.COLLECTED;
    }

    public void affectDeliveryMan(DeliveryManEntity deliveryMan) {
        this.deliveryManEntity = deliveryMan;
    }
}
