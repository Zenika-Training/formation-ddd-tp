package com.zenika.ddd.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class ItemJpaEntity {

    @Id
    private String name;

    @Id
    private BigDecimal price;
}
