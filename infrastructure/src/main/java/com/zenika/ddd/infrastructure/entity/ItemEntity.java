package com.zenika.ddd.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "restaurant_items")
public class ItemEntity {

    @Id
    private String id;

    private String name;

    private double price;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private ItemStatus status;
}
