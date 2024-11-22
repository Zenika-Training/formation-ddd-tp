package com.zenika.ddd.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderJpaEntity {

    @Id
    private String id;

    private String consumerName;
    private String consumerFirstName;
    private String consumerAddress;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateCommande;

    @OneToMany
    private List<ItemJpaEntity> itemVOList;
}
