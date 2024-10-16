package com.zenika.ddd.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEntity {

    @Id
    private String id;

    private String raisonSociale;

    // Adresse
    private String numéro;
    private String rue;
    private String codePostal;
    private String ville;

    // Position
    private Double latitude;
    private Double longitude;
}
