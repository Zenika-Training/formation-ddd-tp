package com.zenika.ddd.infrastructure.entity;

import com.zenika.ddd.aggregateorder.EnumStatusOrder;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "restaurant_orders")
public class OrderEntity {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private EnumStatusOrder status;

    @OneToMany
    private List<ItemEntity> items;
}
