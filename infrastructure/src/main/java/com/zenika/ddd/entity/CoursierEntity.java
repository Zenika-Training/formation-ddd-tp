package com.zenika.ddd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Entity
@Builder
public class CoursierEntity {

    @Id
    private UUID id;

    private String firstName;
    private String lastName;
    private String email;

    @OneToOne
    private AdresseEntity adresse;
}
