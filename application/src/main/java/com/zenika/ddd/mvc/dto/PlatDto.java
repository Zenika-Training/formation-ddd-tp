package com.zenika.ddd.mvc.dto;

import java.util.List;

public class PlatDto {

    private final String nom;
    private final double prix;
    private List<byte[]> images;

    public PlatDto(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return this.nom;
    }

    public Double getPrix() {
        return this.prix;
    }
}
