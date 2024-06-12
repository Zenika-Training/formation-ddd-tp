package com.macif.ddd.brett.catalogue.domain.model;

import com.macif.ddd.brett.Entity;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Modele {

    private UUID id;

    public String getNom() {
        return nom;
    }

    private String nom;

    private String type;

    private String marque;

    private List<Option> options;

    private List<Offre> offres;

    public Modele(UUID id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public UUID getId() {
        return this.id;
    }


    public void ajouterOffre(Offre offre) {

    }

    public void ajouterOption(Option option) {

    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modele modele = (Modele) o;
        return Objects.equals(id, modele.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static ModeleBuilder builder() {
        return new ModeleBuilder();
    }

    public static class ModeleBuilder {
        private UUID id;

        private String nom;

        public ModeleBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public ModeleBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }


        public Modele build() {
            return new Modele(id, nom);
        }



    }

}
