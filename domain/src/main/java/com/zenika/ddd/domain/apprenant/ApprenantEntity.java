package com.zenika.ddd.domain.apprenant;

import com.zenika.ddd.doc.DomainObject;

import java.util.UUID;

@DomainObject
public class ApprenantEntity {
    private UUID uuid;
    private String nom;
    private String prenom;

    public ApprenantEntity() {
    }

    public ApprenantEntity(final UUID uuid, final String nom, final String prenom) {
        this.uuid = uuid;
        this.nom = nom;
        this.prenom = prenom;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

}
