package com.zenika.ddd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@JpaEntity
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdresseEntity {

    @Id
    private UUID id;

    private String street;
    private String city;
    private String zipCode;
    private String country;
}
