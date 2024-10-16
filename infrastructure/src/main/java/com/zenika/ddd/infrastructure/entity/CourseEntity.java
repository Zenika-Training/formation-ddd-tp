package com.zenika.ddd.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity {

    @Id
    private String id;

    private String commandeId;

    @ManyToOne
    private LivreurEntity livreur;

    @Enumerated(EnumType.STRING)
    private com.zenika.ddd.shared.StatutCourse statutCourse;

    // Adresse de destination
    private String adresse;
    private String nomAdresse;
    private Double latitude;
    private Double longitude;

    @ManyToOne
    private RestaurantEntity restaurantEntity;


}
