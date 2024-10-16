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
public class LivreurEntity {

    @Id
    private String id;
    private String nom;
    private String prenom;
    private String email;

    // Position
    private Double latitude;
    private Double longitude;

    private String adresse;

}
